/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.book.service;

import com.example.book.entities.Event;
import com.example.book.exception.EventNotFoundException;
import com.example.book.exception.EventServiceException;
import com.example.book.repository.EventRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author Adedayo
 */

@Service
@Transactional(readOnly = true)
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;
    
    private static final Logger logger =LoggerFactory.getLogger(EventService.class);
   

    /*@Async
    public CompletableFuture<List<Event>> getAllEvent() throws EventNotFoundException, InterruptedException{
       List<Event> events = new ArrayList<>();
       eventRepository.findAll().forEach(events::add);
       if(events.isEmpty()){
           throw new  EventNotFoundException("Events Not Found");
       } 
          Thread.sleep(1000L);    
        return CompletableFuture.completedFuture(events);     
    }**/      
  
    public List<Event> getAllEvent() throws EventNotFoundException{
        List<Event> events = new ArrayList<>();
       eventRepository.findAll().forEach(events::add);
        if(events.isEmpty()){
           throw new  EventNotFoundException("Events Not Found");
       } 
        return events;
    }
   
   
     public Event getEvent(Integer eventId){ 
      Optional<Event> event = eventRepository.findById(eventId);
        if(!event.isPresent())
          throw new EventNotFoundException("Event Not Found with");            
      return event.get();         
    }
   
   
   
     
    @Transactional(rollbackFor = Exception.class)
    public Event addEvent(@Valid @NotNull(message = "Event passed as parameter cannot be null") Event event){ 
        try{
        eventRepository.save(event);
        logger.info("The stuff persisted");
       return event; 
    }catch(ConstraintViolationException cex) {
      throw new EventServiceException(cex.getMessage());
          }
    }
    
    
       
      @Transactional(rollbackFor = Exception.class)
      public Event updateEvent(Integer eventId, @Valid @NotNull(message = 
         "Event passed as parameter cannot be null") Event event)throws EventNotFoundException{
      try{           
          Optional<Event> eve = eventRepository.findById(eventId);
          if(eve.isPresent()){
              eventRepository.save(event);
          } else throw new EventNotFoundException("Event Not Found with");
        
        logger.warn("Event updated successfully");
       return event;  
      }catch(ConstraintViolationException cex) {
        throw new EventServiceException(cex.getMessage());
          }
  }  
    
       
    @Transactional(rollbackFor = Exception.class)
    public void deleteEvent(Integer eventId){
      eventRepository.deleteById(eventId);
   }
}  
