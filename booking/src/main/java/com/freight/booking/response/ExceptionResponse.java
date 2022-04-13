package com.freight.booking.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private String errorMessage;
    private int httpStatusCode;
    private ZonedDateTime timeStamp;

}
