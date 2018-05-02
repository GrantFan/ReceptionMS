package com.reception.exceptionfilter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHadlerActice {
   private static final long serialVersionUID = 1L;
   @ExceptionHandler(value = EntityNotFoundException.class)
   public ErrorMessage entityNotFoundException(HttpServletRequest request, Exception e){
       ErrorMessage errorMessage = new ErrorMessage();
       errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
       errorMessage.setMessage(e.getLocalizedMessage());
       errorMessage.setUrl(request.getRequestURL().toString());
       return errorMessage;
  }
}