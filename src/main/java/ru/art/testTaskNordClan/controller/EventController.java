package ru.art.testTaskNordClan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.art.testTaskNordClan.model.Event;
import ru.art.testTaskNordClan.repository.EventRepository;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value="/allevents", method = RequestMethod.GET)
    public List<Event> allEvents() {
        System.out.println("allEvents" + eventRepository.findAll());
        return eventRepository.findAll();
    }
}
