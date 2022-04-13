package com.freight.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "freight_booking")
@Entity(name = "freightBookingRequestEntity")
public class FreightBookingRequestEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "company_name",nullable = false)
    private String companyName;

    @Column(name = "item_name",nullable = false)
    private String itemName;

    @Column(name = "actual_kg",nullable = false)
    private double kg;

    @JsonIgnore
    @OneToOne(mappedBy = "freightBooking",cascade = CascadeType.ALL)
    private CompanyRegisterEntity company;

    @Column(name = "airline_code",nullable = false)
    private String airlineCode;

    @Column(name = "flight_number",nullable = false)
    private String flightNumber;

    @Column(name = "origin_airport",nullable = false)
    private String originAirport;

    @Column(name = "destination_Airport",nullable = false)
    private String destinationAirport;


    @Column(name = "flight_time",nullable = false)
    @JsonFormat(pattern="yyy-MM-dd HH:mm", timezone="America/Mexico_City")
    private ZonedDateTime flightTime;

    @Column(name = "total_fare",nullable = false)
    private double totalFare;

    @Column(name = "discount_percentage",nullable = false)
    private double discountInPercentage;
}
