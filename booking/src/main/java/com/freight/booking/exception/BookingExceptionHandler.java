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
        ExceptionResponse exception = ExceptionResponse.builder()
                .errorMessage("Data not found")
                .httpStatusCode(HttpStatus.NOT_FOUND.value())
                .timeStamp(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest(BadRequestException e)
    {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .errorMessage(e.getMessage())
                .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .timeStamp(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AirlineRegisterException.class)
    public ResponseEntity<Object> airlineRegisterException(AirlineRegisterException e)
    {
        ExceptionResponse exception = ExceptionResponse.builder()
                .errorMessage(e.getMessage())
                .httpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timeStamp(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
