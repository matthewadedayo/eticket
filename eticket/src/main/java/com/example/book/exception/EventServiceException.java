/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Adedayo
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EventServiceException extends RuntimeException {	

   public EventServiceException() {
         super();
    }
  
    public EventServiceException(String message) {
           super(message);	
   }

}
