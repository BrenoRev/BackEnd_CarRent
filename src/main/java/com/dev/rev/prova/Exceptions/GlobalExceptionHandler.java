package com.dev.rev.prova.Exceptions;

import com.dev.rev.prova.Exceptions.classes.NotFound.CarNotFoundException;
import com.dev.rev.prova.Exceptions.classes.NotFound.ModelNotFoundException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @ExceptionHandler(CarNotFoundException.class)
    protected ResponseEntity<Object> CarException(Exception ex) {

        String errorDescription = ex.getLocalizedMessage();

        if(errorDescription == null) {
            errorDescription = ex.toString();
        }

        ErrorDetails erro = new ErrorDetails();

        erro.setError(errorDescription);
        erro.setCode(HttpStatus.NOT_FOUND.toString());
        erro.setCurrentDate(LocalDateTime.now().format(formatter));
        return new ResponseEntity<>(erro, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    protected ResponseEntity<Object> ModelException(Exception ex) {

        String errorDescription = ex.getLocalizedMessage();

        if(errorDescription == null) {
            errorDescription = ex.toString();
        }

        ErrorDetails erro = new ErrorDetails();

        erro.setError(errorDescription);
        erro.setCode(HttpStatus.NOT_FOUND.toString());
        erro.setCurrentDate(LocalDateTime.now().format(formatter));
        return new ResponseEntity<>(erro, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    protected ResponseEntity<Object> NotValidCar(Exception ex) {

        String errorDescription = ex.getLocalizedMessage();

        if(errorDescription == null) {
            errorDescription = ex.toString();
        }

        ErrorDetails erro = new ErrorDetails();
        erro.setError(errorDescription);
        erro.setCode(HttpStatus.BAD_REQUEST.toString());
        erro.setCurrentDate(LocalDateTime.now().format(formatter));
        return new ResponseEntity<>(erro, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({PropertyReferenceException.class})
    protected ResponseEntity<Object> NoPropertyPagination(Exception ex) {

        String errorDescription = ex.getLocalizedMessage();

        if(errorDescription == null) {
            errorDescription = ex.toString();
        }

        ErrorDetails erro = new ErrorDetails();
        erro.setError(errorDescription);
        erro.setCode(HttpStatus.BAD_REQUEST.toString());
        erro.setCurrentDate(LocalDateTime.now().format(formatter));
        return new ResponseEntity<>(erro, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


}
