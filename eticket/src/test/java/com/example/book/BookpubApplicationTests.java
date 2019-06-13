package com.example.book;


import com.example.book.entities.Event;
import com.example.book.exception.EventNotFoundException;
import com.example.book.repository.EventRepository;
import com.example.book.service.EventService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class BookpubApplicationTests {
    
    @Autowired
    private EventService eventServ;
            
    @MockBean
    private EventRepository eventRep;
    
     //testing Persist method @service level 
    @Test
    public void TestAddEvent() throws Exception{
        Event eve = new Event();
        eve.setEventId(1);
        eve.setEventName("Contemporary Jazz");
        eve.setEventType("Java");
        eve.setEventTag("Jazz");
        eve.setVenue("Eko Hotel and suites");
        eve.setDressCode("light red");
        eve.setAgeLimit("40");
        eve.setPrice(40.00);
        Mockito.when(eventRep.save(eve)).thenReturn(eve);
        assertThat(eventServ.addEvent(eve)).isEqualTo(eve);

    }
    //testing Returning Single Event method @service level
    @Test
    public void getEventById() throws Exception{
        Event eve = new Event();
        eve.setEventId(1);
        eve.setEventName("Contemporary Jazz");
        eve.setEventType("Java");
        eve.setEventTag("Jazz");
        eve.setVenue("Eko Hotel and suites");
        eve.setDressCode("light red");
        eve.setAgeLimit("40");
        eve.setPrice(40.00);
        Mockito.when(eventRep.findById(1)).thenReturn(Optional.of(eve));
        assertThat(eventServ.getEvent(1)).isEqualTo(eve);
    }
    
    //testing Returning All Event method @service level
    @Test
    public void getAllEvent() throws EventNotFoundException, InterruptedException{
        Event eve1 = new Event();
        eve1.setEventId(1);
        eve1.setEventName("Contemporary Jazz");
        eve1.setEventType("Java");
        eve1.setEventTag("Jazz");
        eve1.setVenue("Eko Hotel and suites");
        eve1.setDressCode("light red");
        eve1.setAgeLimit("40");
        eve1.setPrice(40.00);
        
        Event eve2 = new Event();
        eve2.setEventId(2);
        eve2.setEventName("Contemporary Jazz");
        eve2.setEventType("Java");
        eve2.setEventTag("Jazz");
        eve2.setVenue("Eko Hotel and suites");
        eve2.setDressCode("light red");
        eve2.setAgeLimit("40");
        eve2.setPrice(40.00);
        
        List<Event> eventList = new ArrayList<>();
        eventList.add(eve1);
        eventList.add(eve2);
        
        Mockito.when(eventRep.findAll()).thenReturn(eventList);
        assertThat(eventServ.getAllEvent()).isEqualTo(eventList);
    }
    
    
    @Test
    public void updateEvent() throws Exception{
        Event eve = new Event();
        eve.setEventId(1);
        eve.setEventName("Contemporary Jazz");
        eve.setEventType("Java");
        eve.setEventTag("Jazz");
        eve.setVenue("Eko Hotel and suites");
        eve.setDressCode("light red");
        eve.setAgeLimit("40");
        eve.setPrice(40.00);
        Mockito.when(eventRep.findById(1)).thenReturn(Optional.of(eve));
        
        eve.setEventName("Lambda");
        Mockito.when(eventRep.save(eve)).thenReturn(eve);
        
        assertThat(eventServ.updateEvent(1, eve)).isEqualTo(eve);
    }
    //testing delete method @service level
     /*public void deleteEvent() {
        Event eve = new Event();
        eve.setEventId(1);
        eve.setEventName("Lakers");
        eve.setEventType("Java Jazz");
        eve.setEventTag("yes");
        eve.setVenue("ile wa");
        eve.setDressCode("light red");
        eve.setAgeLimit("40");
        
        Mockito.when(eventRep.findById(1)).thenReturn(Optional.of(eve));
        Mockito.when(eventRep.exists(eve.getEventId())).thenReturn(false);
        assertThat(eventRep.exists(eve.getEventId()));
}*/
}

