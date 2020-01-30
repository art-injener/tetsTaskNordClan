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

/**
 * Сontroller class for queries from frontend
 * @author Danilchenko Artem
 */
@RestController
public class EventController {
    /**  property EventRepository  */
    @Autowired
    private EventRepository eventRepository;

    /**
     * Method for mapping request all events on calendar
     * @param user - loging user
     * @return - list of events
     */
    @RequestMapping(value="/allevents", method = RequestMethod.GET)
    public List<Event> allEvents(@AuthenticationPrincipal User user) {
        return eventRepository.findAll(user.getId());
    }
    /**
     * Method for mapping request of delete event from calendar
     * @param event - event that need delete
     * @param user - loging user
     * @return - list of events
     */
    @RequestMapping(value="/event", method=RequestMethod.DELETE)
    public List<Event> removeEvent(@RequestBody Event event,
                                   @AuthenticationPrincipal User user) {
        eventRepository.delete(event);
        return allEvents(user);
    }

    /**
     * Method for mapping request of insert event to calendar
     * @param event - event that need insert
     * @param user - loging user
     * @return - list of events
     */
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
