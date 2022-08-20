package br.com.matheliasc.Vendedores.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoSuchElementException.class)
    public ErroDTO handle(NoSuchElementException e){
        return new ErroDTO(e.getMessage());
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidParameterException.class)
    public ErroDTO handle(InvalidParameterException e){
        return new ErroDTO(e.getMessage());
    }
}
