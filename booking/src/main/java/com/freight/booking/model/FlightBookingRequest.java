package com.freight.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {

    private String originAirport;
    private String destinationAirport;
    private double weightInKg;
}
