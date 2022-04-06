package com.freight.booking.service;


import com.freight.booking.model.AirlineDetail;
import com.freight.booking.model.FlightBookingRequest;
import com.freight.booking.util.AirlineAndCompanyData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FlightSearch {


    private AirlineAndCompanyData flightAndCompanyDetails;

    //get a cheapest flight for a given Origin,Destination and Weight in Kg based on Price by KG and Having available capacity(KG) in the airline
    public AirlineDetail getCheapestFlightByPricePerKg(FlightBookingRequest flightBookingRequest) throws ParseException {

        return getAirlineDetail(flightBookingRequest, Comparator.comparing(AirlineDetail::getPrice_by_kg));
    }

    //get a fastest flight for a given Origin,Destination and Weight in Kg based on duration and Having available capacity(KG) in the airline
    public AirlineDetail getFastestFlightByDurationInMinutes(FlightBookingRequest flightBookingRequest) throws ParseException {

        return getAirlineDetail(flightBookingRequest, Comparator.comparing(AirlineDetail::getDuration_in_minutes));

    }


    //Get flight details based comparator by Price by KG and Duration in minutes
    private AirlineDetail getAirlineDetail(FlightBookingRequest flightBookingRequest, Comparator<AirlineDetail> comparing) throws ParseException {
        List<AirlineDetail> airlineList = flightAndCompanyDetails.getAirlineList();

        Comparator<AirlineDetail> cheapPriceByKg = comparing;
        AirlineDetail airlineDetail = airlineList.stream()
                .filter(origin -> origin.getOriginAirport().equalsIgnoreCase(flightBookingRequest.getOrigin_airport()))
                .filter(destination -> destination.getDestination_Airport().equalsIgnoreCase(flightBookingRequest.getDestination_airport()))
                .filter(capacity -> capacity.getCapacity_kg() >= flightBookingRequest.getWeight_in_kg())
                .min(cheapPriceByKg)
                .map(obj -> obj)
                .orElse(null);
        if(airlineDetail != null) return  airlineDetail;
        return null;
    }
}
