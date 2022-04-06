package com.freight.booking.controller;

import com.freight.booking.model.BookingRequest;
import com.freight.booking.model.FlightBookingRequest;
import com.freight.booking.response.JSONResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Slf4j
class BookingControllerTest {

    @Autowired
    BookingController bookingController;

    //Success test case for booking request Bimbo
    @Test
    void airlineBookingRequestByBimbo() throws ParseException {
        BookingRequest bookingRequest = BookingRequest.builder()
                .company_Name("Bimbo")
                .item_Name("Bread")
                .kg(400)
                .airline_Code("UNITED")
                .flight_Number("AIR-001")
                .originAirport("Mexico City, Mexico")
                .destination_Airport("Cancun, Mexico")
                .flight_Time(new Date(String.valueOf(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("1/5/2022 10:00"))))
                .build();
        ResponseEntity<?> result = bookingController.airlineBookingRequest(bookingRequest);
        log.info("Booking Result :"+result);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    //Success test case for booking request Nestle
    @Test
    void airlineBookingRequestByNestle() throws ParseException {
        BookingRequest bookingRequest = BookingRequest.builder()
                .company_Name("Nestle")
                .item_Name("Chocolates")
                .kg(400)
                .airline_Code("AMERICAN")
                .flight_Number("AIR-003")
                .originAirport("Puerto Vallarta, Mexico")
                .destination_Airport("Mexico City, Mexico")
                .flight_Time(new Date(String.valueOf(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("3/5/2022 10:00"))))
                .build();
        ResponseEntity<?> result = bookingController.airlineBookingRequest(bookingRequest);
        log.info("Booking Result :"+result);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    //Success test case for get a cheap flight
    @Test
    void getCheapestFlight() {
        FlightBookingRequest flightBookingRequest = FlightBookingRequest.builder()
                .origin_airport("Mexico City, Mexico")
                .destination_airport("Cancun, Mexico")
                .weight_in_kg(300.00)
                .build();
        ResponseEntity<JSONResponse> stats = bookingController.getCheapestFlight(flightBookingRequest);
        log.info("Cheap Flight Result :"+stats);
        assertThat(stats.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    //Success test case for get a fastest flight
    @Test
    void getFastestFlight() {
        FlightBookingRequest flightBookingRequest = FlightBookingRequest.builder()
                .origin_airport("Mexico City, Mexico")
                .destination_airport("Cancun, Mexico")
                .weight_in_kg(300.00)
                .build();
        ResponseEntity<JSONResponse> stats = bookingController.getFastestFlight(flightBookingRequest);
        log.info("Fastest Flight Result :"+stats);
        assertThat(stats.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}