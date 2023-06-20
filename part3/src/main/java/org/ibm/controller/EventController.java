package org.ibm.controller;

import org.ibm.model.Event;
import org.ibm.model.User;
import org.ibm.repository.EventRepository;
import org.ibm.service.EventService;
import org.ibm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/ibm")
public class EventController {

  @Autowired
  private EventService eventService;

  @Autowired
  private UserService userService;

  @Autowired
  private EventRepository eventRepository;

  @GetMapping(value = "/")
  public String getInitialPage(Model model) {
    model.addAttribute("events", eventService.getEventList());
    return "events";
  }

  @PostMapping(value = "/")
  public String add(Model model, @RequestParam Integer peopleCount, @RequestParam String place, @RequestParam String creatorFirstName, @RequestParam String creatorLastName) {
    User user = new User();
    user.setLastName(creatorLastName);
    user.setFirstName(creatorFirstName);

    userService.addUser(user);

    Event event = new Event();
    event.setPlace(place);
    event.setPeopleCount(peopleCount);

    Set<Event> eventSet = new HashSet<>();
    eventSet.add(event);
    user.setEventSet(eventSet);



    eventService.addEvent(event);

    return "redirect:/ibm/";
  }

  @PostMapping(value = "/findPlace")
  public String findByPlace(Model model, @RequestParam String place) {
    model.addAttribute("eventInPlace", eventService.getEventsFromName(place));
    model.addAttribute("events", eventService.getEventList());
    return "events";
  }
}