package com.freight.booking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    private String company_Name;
    private String item_Name;
    private double kg;

    private String airline_Code;
    private String flight_Number;
    private String originAirport;
    private String destination_Airport;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm", timezone="America/Mexico_City")
    private Date flight_Time;

    private double total_Fare;
    private double discount_in_Percentage;

}
