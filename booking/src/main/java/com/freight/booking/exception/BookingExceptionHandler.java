package com.freight.booking.exception;

import com.freight.booking.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@Slf4j
@ControllerAdvice
public class BookingExceptionHandler {

    @ExceptionHandler(value = BookingRequestException.class)
    public ResponseEntity<Object> handleBookingException(BookingRequestException e)
    {
        ExceptionResponse exceptionResponse=ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .time_stamp(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest(BadRequestException e)
    {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .time_stamp(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }


}
