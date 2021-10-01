package com.example.reactionGame.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 객체를 사용하지 않은 파라미터 값이 잘못 들어온 경우
     * ref https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-modelattrib-method-args
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> httpMessageNotReadbleException(ConstraintViolationException e) {
        log.error("httpMessageNotReadbleException", e);
        String msg = "1이상 이어야 합니다.";
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }



}
