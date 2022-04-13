package com.freight.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "airline_list")
@Entity(name = "airlineRegisterEntity")
public class AirlineRegisterEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,unique = true)
    private long id;

    @Column(name = "airline_code",nullable = false)
    private String airlineCode;

    @Column(name = "airline_name",nullable = false)
    private String airlineName;

    @Column(name = "flight_number",nullable = false)
    private String flightNumber;

    @Column(name = "origin_airport_name", nullable = false)
    private String originAirportName;

    @Column(name = "destination_airport_name", nullable = false)
    private String destinationAirportName;

    @JsonFormat(pattern="yyy-MM-dd HH:mm", timezone="America/Mexico_City")
    @Column(name = "departure_time", nullable = false)
    private ZonedDateTime departureTime;

    @JsonFormat(pattern="yyy-MM-dd HH:mm", timezone="America/Mexico_City")
    @Column(name = "arrival_time", nullable = false)
    private ZonedDateTime arrivalTime;

    @Column(name = "weight_capacity",nullable = false)
    private double weightCapacity;

    @Column(name = "price_per_kg",nullable = false)
    private double pricePerKg;

    @Column(name = "travel_duration_minute",nullable = false)
    private long travelDurationMinutes;
}
