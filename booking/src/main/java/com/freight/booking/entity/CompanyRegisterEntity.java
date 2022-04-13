package com.freight.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company_list")
@Entity(name = "companyRegisterEntity")
public class CompanyRegisterEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id",unique = true,nullable = false)
    private long id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "freight_booking_id",nullable = false)
    private FreightBookingRequestEntity freightBooking;

    @Column(name = "company_name",nullable = false)
    private String companyName;

    @JsonFormat(pattern = "yyyy")
    @Column(name = "year",nullable = false)
    private int year;

    @Column(name = "total_kg_booked",nullable = false)
    private double totalKgBooked;
}
