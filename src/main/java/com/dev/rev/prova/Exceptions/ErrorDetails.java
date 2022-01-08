package com.dev.rev.prova.Exceptions;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ErrorDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    private String error;
    private String code;
    private String currentDate;

    public ErrorDetails() {
        super();
    }

    public ErrorDetails(String error, String code, String currentDate) {
        this.error = error;
        this.code = code;
        this.currentDate = currentDate;
    }
}