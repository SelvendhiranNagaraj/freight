package com.freight.booking.controller;


import com.freight.booking.exception.BookingRequestException;
import com.freight.booking.model.AirlineDetail;
import com.freight.booking.model.BookingRequest;
import com.freight.booking.model.FlightBookingRequest;
import com.freight.booking.response.JSONResponse;
import com.freight.booking.service.BookingService;
import com.freight.booking.service.FlightSearch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/v1/api/freight/airline-service")
public class BookingController {

    private BookingService bookingService;
    private FlightSearch flightSearch;

    @PostMapping(path = "/book",consumes = "application/json",produces = "application/json")
    public ResponseEntity<JSONResponse> airlineBookingRequest(@RequestBody BookingRequest bookingRequest)
    {
        JSONResponse jsonResponse = null;
        BookingRequest response = null;
        try {
            response = bookingService.companyBookRequest(bookingRequest);
            if(response != null)
            {
                jsonResponse = JSONResponse.builder()
                        .message("Booking successfully registered")
                        .data(response)
                        .status_Code(HttpStatus.CREATED.value())
                        .build();
                return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
            }else
            {
                jsonResponse = JSONResponse.builder()
                        .message("Booking Not registered due to Data not found or Airline having less capacity..!")
                        .data(response)
                        .status_Code(HttpStatus.NOT_FOUND.value())
                        .build();
                return new ResponseEntity<>(jsonResponse, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new BookingRequestException("Booking Not registered due to server error or BAD Request..!");
        }

    }

    @GetMapping(path = "/get-cheapest-airline",consumes = "application/json",produces = "application/json")
    public ResponseEntity<JSONResponse> getCheapestFlight(@RequestBody FlightBookingRequest flightBookingRequest)
    {
        AirlineDetail airlineDetail = null;
        JSONResponse jsonResponse = new JSONResponse();
        try {

            airlineDetail = flightSearch.getCheapestFlightByPricePerKg(flightBookingRequest);
            if(airlineDetail != null)
            {
                jsonResponse.setData(airlineDetail);
                jsonResponse.setMessage("Cheapest Flight FOUND based on price per KG..!");
                jsonResponse.setStatus_Code(HttpStatus.OK.value());
                return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
            }else
            {
                jsonResponse.setData(airlineDetail);
                jsonResponse.setMessage("Flight NOT FOUND due to data mismatch or Airline having less capacity ..!");
                jsonResponse.setStatus_Code(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(jsonResponse, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e)
        {
            throw new BookingRequestException("BAD Request on your search criteria..!");
        }

    }

    @GetMapping(path = "/get-fastest-airline",consumes = "application/json",produces = "application/json")
    public ResponseEntity<JSONResponse> getFastestFlight(@RequestBody FlightBookingRequest flightBookingRequest)
    {
        AirlineDetail airlineDetail = null;
        JSONResponse jsonResponse = new JSONResponse();
        try {

            airlineDetail = flightSearch.getFastestFlightByDurationInMinutes(flightBookingRequest);
            if(airlineDetail != null)
            {
                jsonResponse.setData(airlineDetail);
                jsonResponse.setMessage("Flight FOUND based on fastest route by Duration in minutes..!");
                jsonResponse.setStatus_Code(HttpStatus.OK.value());
                return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
            }else
            {
                jsonResponse.setData(airlineDetail);
                jsonResponse.setMessage("Flight NOT FOUND on your search criteria or data mismatch..!");
                jsonResponse.setStatus_Code(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(jsonResponse, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e)
        {
            throw new BookingRequestException("BAD Request on your search criteria..!");
        }
    }
}
