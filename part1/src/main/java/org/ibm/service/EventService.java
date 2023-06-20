package org.ibm.service;

import org.ibm.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

  private List<Event> eventList = new ArrayList<>();

  public EventService() {
    Event event = new Event();
    event.setPlace("ibm");
    event.setPeopleCount(0);
    //    event.setMaxPeople(20);
    eventList.add(event);
  }

  public List<Event> getEventList() {
    return eventList;
  }

  public void addEvent(Event event) {
    eventList.add(event);
  }
}
