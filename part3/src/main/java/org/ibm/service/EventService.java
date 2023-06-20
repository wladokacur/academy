package org.ibm.service;

import org.ibm.model.Event;
import org.ibm.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  private List<Event> eventList = new ArrayList<>();

  public EventService() {
    Event event = new Event();
    event.setPlace("ibm");
    event.setPeopleCount(50);
    eventList.add(event);
  }

  //  public List<PartyEvent> getEventList() {
  //    return partyEventList;
  //  }

  public void addEvent(Event event) {
    eventRepository.saveAndFlush(event);
  }

  public List<Event> getEventList() {
    return eventRepository.findAll();
  }

  public void addEventOnlyFromIBM(Event event) {
    if (event.getPlace().equalsIgnoreCase("IBM")) {
      eventRepository.saveAndFlush(event);
    }
  }
  public Event getEventFromName(String name) {
    return eventRepository.findByplace(name);
  }

  public Set<Event> getEventsFromName(String place) {
    return eventRepository.getEventByPlaceName(place);
  }

}