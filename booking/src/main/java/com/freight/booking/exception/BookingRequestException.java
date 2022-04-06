package com.freight.booking.exception;

public class BookingRequestException extends RuntimeException{
    public BookingRequestException(String message) {
        super(message);
    }
}
