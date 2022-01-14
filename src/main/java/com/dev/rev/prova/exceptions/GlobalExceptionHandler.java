package com.dev.rev.prova.exceptions;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dev.rev.prova.exceptions.classes.notfound.CarNotFoundException;
import com.dev.rev.prova.exceptions.classes.notfound.ModelNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Global
    @ExceptionHandler({Exception.class, io.jsonwebtoken.SignatureException.class})
    protected ResponseEntity<Object> globalExpcetion(Exception ex) {

        ErrorDetails erro =
                new ErrorDetails(ex.getLocalizedMessage(),
                        HttpStatus.NOT_ACCEPTABLE.toString(),
                        LocalDateTime.now().format(formatter));

        return new ResponseEntity<>(erro, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({DataIntegrityViolationException.class, ConstraintViolationException.class, SQLException.class})
    protected ResponseEntity<Object> sqlException(Exception ex) {

        ErrorDetails erro = new ErrorDetails();

        erro.setError("Já existe um dado com esse valor");
        erro.setCode(HttpStatus.CONFLICT.toString());
        erro.setCurrentDate(LocalDateTime.now().format(formatter));
        return new ResponseEntity<>(erro, new HttpHeaders(), HttpStatus.CONFLICT);
    }


    @ExceptionHandler(CarNotFoundException.class)
    protected ResponseEntity<Object> carException(Exception ex) {

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
    protected ResponseEntity<Object> modelException(Exception ex) {

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

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> notValidCar(Exception ex) {

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
    protected ResponseEntity<Object> noPropertyPagination(Exception ex) {

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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<Object> jsonDeserializerException(Exception ex){

        ErrorDetails erro = new ErrorDetails();

        erro.setError("CarType or CarTransmission or CarColor or CarFuel was typed incorrect");
        erro.setCode(HttpStatus.BAD_REQUEST.toString());
        erro.setCurrentDate(LocalDateTime.now().format(formatter));
        return new ResponseEntity<>(erro, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


}
