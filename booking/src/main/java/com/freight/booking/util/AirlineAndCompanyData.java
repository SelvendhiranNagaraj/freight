package com.freight.booking.util;


import com.freight.booking.model.AirlineDetail;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AirlineAndCompanyData {
    SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm");

    //Total kg booked By company and year wise
    public double getCompanyBookedDataByKgYear(String companyName, int year) {
        //Bimbo company static data(Total kg per year) 2021 and 2022
        if(companyName.equalsIgnoreCase("Bimbo") && year == 2022)
            return 9800.00;

        //Nestle company static data(Total kg per year)
        if(companyName.equalsIgnoreCase("Nestle") && year == 2022)
            return 9000.00;

        return -1;
    }


//Static data for Airline list details adn  Flight Duration in minutes
    public List<AirlineDetail> getAirlineList() throws ParseException {
        List<AirlineDetail> airlineList = new ArrayList<>();
        //United Airlines
        airlineList.add( new AirlineDetail(
                "UNITED",
                "AIR-001",
                "Mexico City, Mexico",
                "Cancun, Mexico",
                new Date(String.valueOf(dateFormat.parse("1/5/2022 10:00"))),
                100.00,180,900));
        airlineList.add( new AirlineDetail(
                "UNITED",
                "AIR-002",
                "Mexico City, Mexico",
                "Cancun, Mexico",
                new Date(String.valueOf(dateFormat.parse("2/5/2022 11:00"))),
                50.00,200,2000));
        airlineList.add( new AirlineDetail(
                "UNITED",
                "AIR-003",
                "Mexico City, Mexico",
                "Cancun, Mexico",
                new Date(String.valueOf(dateFormat.parse("3/5/2022 10:00"))),
                250.00,150,1500));
        airlineList.add( new AirlineDetail(
                "UNITED",
                "AIR-004",
                "Mexico City, Mexico",
                "Cancun, Mexico",
                new Date(String.valueOf(dateFormat.parse("4/5/2022 10:00"))),
                200,120,1000));


        //American Airlines
        airlineList.add( new AirlineDetail(
                "AMERICAN",
                "AIR-001",
                "Puerto Vallarta, Mexico",
                "Mexico City, Mexico",
                new Date(String.valueOf(dateFormat.parse("1/5/2022 10:00"))),
                90.00,165,800));
        airlineList.add( new AirlineDetail(
                "AMERICAN",
                "AIR-001",
                "Puerto Vallarta, Mexico",
                "Mexico City, Mexico",
                new Date(String.valueOf(dateFormat.parse("2/5/2022 10:00"))),
                35.00,115,1800));
        airlineList.add( new AirlineDetail(
                "AMERICAN",
                "AIR-003",
                "Puerto Vallarta, Mexico",
                "Mexico City, Mexico",
                new Date(String.valueOf(dateFormat.parse("3/5/2022 10:00"))),
                20.00,175,2500));

        //VIVA AERO Airlines
        airlineList.add( new AirlineDetail(
                "VIVA",
                "AIR-001",
                "Puerto Vallarta, Mexico",
                "Mexico City, Mexico",
                new Date(String.valueOf(dateFormat.parse("1/5/2022 11:00"))),
                60.00,280,900));
        airlineList.add( new AirlineDetail(
                "VIVA",
                "AIR-002",
                "Puerto Vallarta, Mexico",
                "Mexico City, Mexico",
                new Date(String.valueOf(dateFormat.parse("2/5/2022 11:00"))),
                30.00,350,2500));
        airlineList.add( new AirlineDetail(
                "VIVA",
                "AIR-003",
                "Puerto Vallarta, Mexico",
                "Mexico City, Mexico",
                new Date(String.valueOf(dateFormat.parse("3/5/2022 11:00"))),
                15.00,150,1500));

        return  airlineList;
    }

}
