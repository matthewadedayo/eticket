/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.book.controller;

import com.example.book.entities.Event;
import com.example.book.service.EventService;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adedayo
 */

 @RestController
public class EventController {
     
     @Autowired
     EventService eventService;
     
     private static final Logger logger =LoggerFactory.getLogger(EventService.class);
     
   @RequestMapping("/events/{eventId}")
    public CompletableFuture<Event> getEvent(@PathVariable Integer eventId) throws InterruptedException{
        Event event= eventService.getEvent(eventId);    
        logger.info("Event Available");
        return CompletableFuture.completedFuture(event);
    }
     
    /*@RequestMapping(method=RequestMethod.GET, value="/events")
    public CompletableFuture<List<Event>> getEvents() throws InterruptedException{
        return eventService.getAllEvent();
    }**/
    
      @CrossOrigin(origins= "http://localhost:3000")
      @RequestMapping(method=RequestMethod.GET, value="/events")
    public List<Event> getEvents() throws InterruptedException{
        return eventService.getAllEvent();
    }
    
    
    @PostMapping("/events")
    public void addEvent(@RequestBody Event event) throws InterruptedException{
        eventService.addEvent(event);
       
    }
    
    @PutMapping("/events/update/{eventId}")
    public Event updateEvent(@PathVariable Integer eventId, @RequestBody Event event) throws InterruptedException{
         return eventService.updateEvent(eventId, event); 
     }
    
     @DeleteMapping("/events/delete/{eventId}")
    public void deleteEvent(@PathVariable Integer eventId) throws InterruptedException{
         eventService.deleteEvent(eventId);
         
    }    
}
