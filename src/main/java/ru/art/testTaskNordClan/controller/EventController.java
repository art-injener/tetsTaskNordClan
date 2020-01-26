package ru.art.testTaskNordClan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
        return eventRepository.findAll();
    }

    @RequestMapping(value="/event", method=RequestMethod.DELETE)
    public List<Event> removeEvent(@RequestBody Event event) {
        eventRepository.delete(event);
        return allEvents();
    }

    @RequestMapping(value="/event", method=RequestMethod.POST)
    public Event addEvent(@RequestBody Event event) {

        if(eventRepository.checkForExistingEvent(event.getStart(), event.getEnd()) != 0) {
            return null;
        }
        return eventRepository.save(event);
    }
}
