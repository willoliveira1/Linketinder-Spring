package br.com.linketinder.auxiliar.controller;

import br.com.linketinder.auxiliar.exception.BenefitNotFoundException;
import br.com.linketinder.auxiliar.exception.LanguageNotFoundException;
import br.com.linketinder.auxiliar.exception.SkillNotFoundException;
import br.com.linketinder.auxiliar.exception.StateNotFoundException;
import br.com.linketinder.auxiliar.util.ApiErrors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(BenefitNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors handleBenefitNotFoundException(BenefitNotFoundException e) {
        String errorMessage = e.getMessage();
        return new ApiErrors(errorMessage);
    }

    @ExceptionHandler(LanguageNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors handleLanguageNotFoundException(LanguageNotFoundException e) {
        return new ApiErrors(e.getMessage());
    }

    @ExceptionHandler(SkillNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors handleSkillNotFoundException(SkillNotFoundException e) {
        return new ApiErrors(e.getMessage());
    }

    @ExceptionHandler(StateNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors handleStateNotFoundException(StateNotFoundException e) {
        return new ApiErrors(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleBadRequestException(MethodArgumentNotValidException e) {
        List<String> errorMessages = e
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErrors(errorMessages);
    }

}
