package com.datadito.aom.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class HttpResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Turkey")
    private Date timeStamp;
    private int statusCodeValue;
    private HttpStatus httpStatus;
    private String reason;
    private String message;

    public HttpResponse(int statusCodeValue,
                        HttpStatus httpStatus,
                        String reason,
                        String message) {
        this.timeStamp = new Date();
        this.statusCodeValue = statusCodeValue;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
    }
}
