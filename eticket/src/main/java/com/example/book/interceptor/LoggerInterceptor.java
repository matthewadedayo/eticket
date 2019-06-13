/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.book.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Adedayo
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {
    
    private static final Logger logger =LoggerFactory.getLogger(LoggerInterceptor.class);
    
       
    @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse
          response, Object handler) throws Exception {
            System.out.println("Pre Handle method is Calling");
               return true;
            }
      
      
      @Override
          public void postHandle(HttpServletRequest request, HttpServletResponse
             response, Object handler, ModelAndView modelAndView) throws Exception {
             System.out.println("Post Handle method is Calling");
          }
          
          
          @Override
             public void afterCompletion(HttpServletRequest request,
               HttpServletResponse response, Object handler, Exception exception) throws Exception {
                   System.out.println("Request and Response is completed");
             }
}
