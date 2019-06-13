/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.book.exception;

import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Adedayo
 */
public class ExceptionHandlerAdvice {
    
    @ControllerAdvice
   public class EventServiceErrorAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
       @ExceptionHandler({EventNotFoundException.class})
        public void handle(EventNotFoundException e) {}
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
       @ExceptionHandler({EventServiceException.class, SQLException.class, NullPointerException.class})
         public void handle() {}
    
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
      //  @ExceptionHandler({DogsServiceValidationException.class})
       //  public void handle(DogsServiceValidationException e) {}
}
}
