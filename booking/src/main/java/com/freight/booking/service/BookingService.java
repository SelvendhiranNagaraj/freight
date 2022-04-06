package com.freight.booking.service;


import com.freight.booking.model.AirlineDetail;
import com.freight.booking.model.BookingRequest;
import com.freight.booking.util.AirlineAndCompanyData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class BookingService {

    private AirlineAndCompanyData flightAndCompanyDetails;
    private static final double DISCOUNT_PERCENTAGE = 5.00;
    private static final double TOTAL_DISCOUNT_KG=10000.00;


    //Business logic for When a company has booked more than 10000Kg in the current year gets a 5% discount in the fares.
    public BookingRequest companyBookRequest(final BookingRequest cargoBookingRequest) throws ParseException {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(cargoBookingRequest.getFlight_Time());
        List<AirlineDetail> airlineList = flightAndCompanyDetails.getAirlineList();
        //Request validation based on Airline code, flight number,origin, destination, timing
        double priceByAirline = airlineList.stream()
                .filter(code -> code.getAirline_Code().equalsIgnoreCase(cargoBookingRequest.getAirline_Code()))
                .filter(airnum -> airnum.getFlight_Number().equalsIgnoreCase(cargoBookingRequest.getFlight_Number()))
                .filter(time -> time.getFlight_Time().compareTo(cargoBookingRequest.getFlight_Time()) == 0)
                .filter(origin -> origin.getOriginAirport().equalsIgnoreCase(cargoBookingRequest.getOriginAirport()))
                .filter(destination -> destination.getDestination_Airport().equalsIgnoreCase(cargoBookingRequest.getDestination_Airport()))
                .filter(capacity -> capacity.getCapacity_kg() >= cargoBookingRequest.getKg())
                .map(price -> price.getPrice_by_kg())
                .findFirst()
                .orElse((double) -1);

        //If validation fail return null response to controller
        if(priceByAirline == -1) return null;
        //return valid response to controller
        else
        {
            //Assigning booking request to response  and get totalKg which was booked by a company
            BookingRequest response = cargoBookingRequest;
            double totalKgBookedByCompany =
                    flightAndCompanyDetails.getCompanyBookedDataByKgYear(cargoBookingRequest.getCompany_Name(),
                            calendar.get(Calendar.YEAR));

            double curr_total_kg = totalKgBookedByCompany+cargoBookingRequest.getKg();
            double totalPrice = curr_total_kg * priceByAirline;


            //When a company has booked more than 10000Kg in the current year gets a 5% discount in the fares.
            if(curr_total_kg > TOTAL_DISCOUNT_KG)
            {
                response.setTotal_Fare(getDiscount(totalPrice,DISCOUNT_PERCENTAGE));
                response.setDiscount_in_Percentage(DISCOUNT_PERCENTAGE);
            }
            else
            {
                response.setTotal_Fare(totalPrice);
                response.setDiscount_in_Percentage(0);
            }
            return response;

        }
    }

    //Get discount price
    public double getDiscount(double airlinePrice, double discount) {
        double offerPrice = 100 - discount;
        return (offerPrice * airlinePrice) / 100;
    }


}
