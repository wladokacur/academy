package org.ibm.controller;

import org.ibm.model.Event;
import org.ibm.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ibm")
public class EventController {

  @Autowired
  private EventService eventService;

  @GetMapping(value = "/")
  public String getAllEvents(Model model) {
    model.addAttribute("events", eventService.getEventList());
    model.addAttribute("partyEvent", new Event());
    return "events";
  }

  @PostMapping(value = "/")
  public String add(Model model, @ModelAttribute Event event) {
    eventService.addEvent(event);
    return "redirect:/ibm/";
  }
}
