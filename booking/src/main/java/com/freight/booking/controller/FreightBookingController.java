package com.freight.booking.controller;



import com.freight.booking.entity.FreightBookingRequestEntity;
import com.freight.booking.exception.AirlineRegisterException;
import com.freight.booking.model.FreightBookingRequestModel;
import com.freight.booking.model.FlightBookingRequest;
import com.freight.booking.response.JSONResponse;
import com.freight.booking.service.FreightBookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/freight")
public class FreightBookingController {

    private FreightBookingService freightBookingService;

    @PostMapping(path = "/book",consumes = "application/json",produces = "application/json")
    public ResponseEntity<JSONResponse> freightBookingRequest(@RequestBody FreightBookingRequestModel freightBookingRequest)
    {
        try
        {
            FreightBookingRequestEntity response = freightBookingService.freightBookingRequest(freightBookingRequest);
            if(response != null)
            {
                JSONResponse jsonResponse = JSONResponse.builder()
                        .message("Booking successfully")
                        .responseData(response)
                        .statusCode(HttpStatus.CREATED.value())
                        .timeStamp(ZonedDateTime.now())
                        .build();
                return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
            }else
            {
                throw  new AirlineRegisterException("Request not processed");
            }
        }catch (Exception e)
        {
            throw  new AirlineRegisterException("Internal Server Error");
        }
    }

    @GetMapping(path = "/get-cheapest-airline",consumes = "application/json",produces = "application/json")
    public ResponseEntity<JSONResponse> getCheapestFlight(@RequestBody FlightBookingRequest flightBookingRequest)
    {
        return null;
    }

    @GetMapping(path = "/get-fastest-airline",consumes = "application/json",produces = "application/json")
    public ResponseEntity<JSONResponse> getFastestFlight(@RequestBody FlightBookingRequest flightBookingRequest)
    {
        return null;
    }
}
