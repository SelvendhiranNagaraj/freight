package com.freight.booking.controller;

import com.freight.booking.entity.AirlineRegisterEntity;
import com.freight.booking.exception.AirlineRegisterException;
import com.freight.booking.response.JSONResponse;
import com.freight.booking.service.AirlineRegisterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/airline",consumes = "application/json",produces = "application/json")
@Slf4j
@AllArgsConstructor
public class AirlineRegisterController {

    private AirlineRegisterService airlineRegisterService;

    @PostMapping(path = "/save")
    public ResponseEntity<JSONResponse> saveAirline(@RequestBody AirlineRegisterEntity airlineRegisterEntity)
    {
        try {
            AirlineRegisterEntity response = airlineRegisterService.saveAirline(airlineRegisterEntity);
            if(response != null)
            {
                JSONResponse jsonResponse = JSONResponse.builder()
                        .responseData(response)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Airline Registered successfully")
                        .timeStamp(ZonedDateTime.now())
                        .build();
                return new ResponseEntity<>(jsonResponse,HttpStatus.CREATED);
            }else
            {
                throw new AirlineRegisterException("Data not registered due to DB or Server issue");
            }
        }catch (Exception e)
        {
            throw new AirlineRegisterException("Internal Server Error");
        }

    }

    @GetMapping(path = "/get/{id}")
    public Optional<AirlineRegisterEntity> getAirline(@PathVariable Long id)
    {
        return airlineRegisterService.getAirlineById(id);

    }

    @GetMapping(path = "/get-all")
    public List<AirlineRegisterEntity> getAllAirline()
    {
        return airlineRegisterService.getAllAirline();

    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteAirline(@PathVariable long id)
    {
        return airlineRegisterService.deleteAirlineById(id);
    }

    @PostMapping
    public AirlineRegisterEntity updateAirline(@RequestBody AirlineRegisterEntity freightBookingRequest)
    {
        return airlineRegisterService.updateAirlineById(freightBookingRequest);
    }
}
