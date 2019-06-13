/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.book.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adedayo
 */
@Entity
@Table(name = "EVENT")
@XmlRootElement(name="event")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "EVENT_ID")
    private Integer eventId;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EVENT_NAME", nullable = false)
    private String eventName;

    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "EVENT_TYPE", nullable = false)
    private String eventType;

    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "EVENT_TAG", nullable = false)
    private String eventTag;

    @Size(max = 100)
    @Column(name = "AGE_LIMIT", nullable = false)
    private String ageLimit;
    
    @Size(max = 100)
    @Column(name = "VENUE", nullable = false)
    private String venue;
    
    @Size(max = 100)
    @Column(name = "DRESS_CODE")
    private String dressCode;
    
    @Column(name = "PRICE", nullable = false)
    private double price;
    
     public Event() {
    }
     
    public Event(Integer eventId, String eventName, String eventType, String eventTag, String eventDescription, 
                 String ageLimit, String venue, String dressCode, double price) {
        
         this.eventId = eventId;
         this.eventName = eventName;
         this.eventType = eventType;
         this.eventTag = eventTag;
         this.ageLimit = ageLimit;
         this.venue = venue;
         this.price = price;
         this.dressCode = dressCode;
    }

    public Event(Integer eventId) {
        this.eventId = eventId;
    }

    public Event(Integer eventId, String eventType) {
        this.eventId = eventId;
        this.eventType = eventType;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTag() {
        return eventTag;
    }

    public void setEventTag(String eventTag) {
        this.eventTag = eventTag;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
    
    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String dressCode) {
        this.dressCode = dressCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
  
  
    
    
   
    @XmlTransient
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (!Objects.equals(this.eventId, other.eventId)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "com.mytickets.entities.Event[ eventId=" + eventId + " ]";
    }

   

}
