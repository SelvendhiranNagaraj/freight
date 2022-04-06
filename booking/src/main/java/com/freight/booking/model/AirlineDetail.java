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
    private String airline_Code;
    private String flight_Number;
    private String originAirport;
    private String destination_Airport;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm", timezone="America/Mexico_City")
    private Date flight_Time;
    private double price_by_kg;
    private long duration_in_minutes;
    private long capacity_kg;

}
