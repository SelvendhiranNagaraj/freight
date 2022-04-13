package com.freight.booking.controller;


import com.freight.booking.entity.CompanyRegisterEntity;
import com.freight.booking.exception.AirlineRegisterException;
import com.freight.booking.model.AirlineDetail;
import com.freight.booking.response.JSONResponse;
import com.freight.booking.service.CompanyRegisterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(path = "/company",consumes = "application/json",produces = "application/json")
public class CompanyRegisterController {

    private CompanyRegisterService companyRegisterService;

    @PostMapping(path = "/save")
    public ResponseEntity<JSONResponse> saveCompany(@RequestBody AirlineDetail companyRequest)
    {
        try{
            CompanyRegisterEntity companyRegisterEntity = companyRegisterService.saveCompany(companyRequest);
            if(companyRegisterEntity != null)
            {
                JSONResponse jsonResponse = JSONResponse.builder()
                        .message("Company data insert success")
                        .statusCode(HttpStatus.CREATED.value())
                        .responseData(companyRegisterEntity)
                        .timeStamp(ZonedDateTime.now())
                        .build();
                return new ResponseEntity<>(jsonResponse,HttpStatus.CREATED);
            }else
            {
                throw new AirlineRegisterException("Data not insert due to server issue");
            }
        }catch (Exception e)
        {
         throw new AirlineRegisterException("Internal Server Error");
        }

    }


}
