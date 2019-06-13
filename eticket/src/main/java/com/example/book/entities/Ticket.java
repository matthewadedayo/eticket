/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.book.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adedayo
 */
@Entity
@Table(name = "TICKET", catalog = "", schema = "TICKET")
@XmlRootElement
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "TICKET_ID")
    private Integer ticketId;

    @Size(max = 100)
    @Column(name = "TICKET_CODE")
    private String ticketCode;

    @Size(max = 20)
    @Column(name = "TICKET_TAG")
    private String ticketTag;
    
    @Size(max = 100)
    @Column(name = "TICKET_CATEGORY")
    private String ticketCategory;
    
    @Size(max = 20)
    @Column(name = "TICKET_QUANTITY")
    private int quantity;
    
    @Column(name = "PRICE")
    private Double Price;

    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @ManyToOne
    private Event eventId;
    

    protected Ticket() {
    }

    public Ticket(Integer ticketId, String ticketCode, String ticketTag, String 
                      ticketCategory, int quantity, Double Price) {
        this.ticketId = ticketId;
        this.ticketCode = ticketCode;
        this.ticketTag = ticketTag;
        this.ticketCategory = ticketCategory;
        this.quantity = quantity;
        this.Price = Price;
    }
    
    

    public Ticket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getTicketTag() {
        return ticketTag;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setTicketTag(String ticketTag) {
        this.ticketTag = ticketTag;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "com.mytickets.entities.Ticket[ ticketId=" + ticketId + " ]";
    }

}