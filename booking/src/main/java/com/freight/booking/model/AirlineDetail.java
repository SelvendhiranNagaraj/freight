package com.freight.booking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirlineDetail {
    private String airlineCode;
    private String flightNumber;
    private String originAirport;
    private String destinationAirport;

    @JsonFormat(pattern="yyy-MM-dd HH:mm", timezone="America/Mexico_City")
    private Date flightTime;

    private double priceByKg;
    private long durationInMinutes;
    private long capacityKg;

}
