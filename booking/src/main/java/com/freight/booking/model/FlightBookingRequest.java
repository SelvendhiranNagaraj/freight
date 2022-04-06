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

    private String origin_airport;
    private String destination_airport;
    private double weight_in_kg;
}
