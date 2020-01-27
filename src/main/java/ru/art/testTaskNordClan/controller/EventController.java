package ru.art.testTaskNordClan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.art.testTaskNordClan.model.Event;
import ru.art.testTaskNordClan.model.User;
import ru.art.testTaskNordClan.repository.EventRepository;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value="/allevents", method = RequestMethod.GET)
    public List<Event> allEvents(@AuthenticationPrincipal User user)
    {
        return eventRepository.findAll(user.getId());
    }

    @RequestMapping(value="/event", method=RequestMethod.DELETE)
    public List<Event> removeEvent(@RequestBody Event event,
                                   @AuthenticationPrincipal User user) {
        eventRepository.delete(event);
        return allEvents(user);
    }

    @RequestMapping(value="/event", method=RequestMethod.POST)
    public Event addEvent(@RequestBody Event event,
                          @AuthenticationPrincipal User user) {

        if(eventRepository.checkForExistingEvent(event.getStart(), event.getEnd(),user.getId()) != 0) {
            return null;
        }
        event.setUserId(user.getId());
        return eventRepository.save(event);
    }
}
