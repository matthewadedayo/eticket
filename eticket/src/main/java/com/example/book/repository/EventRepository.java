/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.book.repository;

import com.example.book.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Adedayo
 */
public interface EventRepository extends JpaRepository<Event,Integer> {
    
}
