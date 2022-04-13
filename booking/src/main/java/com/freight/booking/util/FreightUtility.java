package com.freight.booking.util;

public class FreightUtility {
    private double getDiscount(double airlinePrice, double discount) {
        double offerPrice = 100 - discount;
        return (offerPrice * airlinePrice) / 100;
    }
}
