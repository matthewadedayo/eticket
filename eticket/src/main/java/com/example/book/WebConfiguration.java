/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.book;

import com.example.book.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Adedayo
 */

@Component
     public class WebConfiguration implements WebMvcConfigurer {
    
   
    @Bean
      public LoggerInterceptor loggerInterceptor() {
       return new LoggerInterceptor();
     }
    
    @Override
        public void addInterceptors(InterceptorRegistry registry) {
           registry.addInterceptor(loggerInterceptor());
           }
    
        
}
