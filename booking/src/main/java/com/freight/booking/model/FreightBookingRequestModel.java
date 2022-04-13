package com.freight.booking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreightBookingRequestModel {
    private String companyName;
    private String itemName;
    private double kg;
    private String airlineCode;
    private String flightNumber;
    private String originAirport;
    private String destinationAirport;

    @JsonFormat(pattern="yyy-MM-dd HH:mm", timezone="America/Mexico_City")
    private ZonedDateTime flightTime;

    private double totalFare;
    private double discountInPercentage;

}
