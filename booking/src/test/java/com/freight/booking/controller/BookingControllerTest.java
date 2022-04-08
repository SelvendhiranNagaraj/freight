package com.freight.booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freight.booking.model.BookingRequest;
import com.freight.booking.model.FlightBookingRequest;
import com.freight.booking.service.BookingService;
import com.freight.booking.service.FlightSearch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BookingController.class})
@ExtendWith(SpringExtension.class)
class BookingControllerTest {
    @Autowired
    private BookingController bookingController;

    @MockBean
    private BookingService bookingService;

    @MockBean
    private FlightSearch flightSearch;

    @Test
    void testAirlineBookingRequest() throws Exception {
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setAirline_Code("Airline Code");
        bookingRequest.setCompany_Name("Company Name");
        bookingRequest.setDestination_Airport("Destination Airport");
        bookingRequest.setDiscount_in_Percentage(10.0d);
        bookingRequest.setFlight_Number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        bookingRequest.setFlight_Time(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        bookingRequest.setItem_Name("Item Name");
        bookingRequest.setKg(10.0d);
        bookingRequest.setOriginAirport("Origin Airport");
        bookingRequest.setTotal_Fare(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(bookingRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testGetCheapestFlight() throws Exception {
        FlightBookingRequest flightBookingRequest = new FlightBookingRequest();
        flightBookingRequest.setDestination_airport("Destination airport");
        flightBookingRequest.setOrigin_airport("Origin airport");
        flightBookingRequest.setWeight_in_kg(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(flightBookingRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/get-cheapest-airline")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testGetFastestFlight() throws Exception {
        FlightBookingRequest flightBookingRequest = new FlightBookingRequest();
        flightBookingRequest.setDestination_airport("Destination airport");
        flightBookingRequest.setOrigin_airport("Origin airport");
        flightBookingRequest.setWeight_in_kg(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(flightBookingRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/get-fastest-airline")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

