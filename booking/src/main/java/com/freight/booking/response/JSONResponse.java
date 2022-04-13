package com.freight.booking.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JSONResponse {
    private String message;
    private int statusCode;
    private Object responseData;
    private ZonedDateTime timeStamp;
}
