package ru.art.testTaskNordClan.controller;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.art.testTaskNordClan.model.Event;
import ru.art.testTaskNordClan.model.User;
import ru.art.testTaskNordClan.repository.EventRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {
    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    EventController eventCtrl;

    private Event event = null;

    @Before
    public void setUp() throws Exception {
        long testId = 1L;
        User user = new User();
        user.setId(testId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime eventStart = LocalDateTime.parse("2020-01-30 10:00:00", formatter);
        LocalDateTime eventEnd = LocalDateTime.parse("2020-01-30 11:30:00", formatter);

        event = new Event(1L,
                "newEvent",
                "newDesc",
                eventStart,
                eventEnd);
        eventCtrl.addEvent(event,user);
    }

    @Test
    public void allEventsTest() {
        long testId = 1L;
        when(eventRepository.findAll(testId)).thenReturn(ImmutableList.of());
        User user = new User();
        user.setId(testId);
        List<Event> listOfEvent = eventCtrl.allEvents(user);
        assert (listOfEvent != null);
        verify(eventRepository).findAll(testId);
    }

    @Test
    public void removeEventTest() {
        long testId = 1L;
        User user = new User();
        user.setId(testId);

        when(eventRepository.findAll(testId)).thenReturn(ImmutableList.of()).thenReturn(null);
        eventCtrl.removeEvent(event,user);
        List<Event> listOfEvent = eventCtrl.allEvents(user);
        assert (listOfEvent == null);
    }

    @Test
    public void addEventTest() {
        long testId = 2L;
        when(eventRepository.findAll(testId)).thenReturn(ImmutableList.of());

        User user = new User();
        user.setId(testId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime eventStart = LocalDateTime.parse("2020-01-30 12:00:00", formatter);
        LocalDateTime eventEnd = LocalDateTime.parse("2020-01-30 16:30:00", formatter);

        Event event = new Event(1000L,
                "newEvent",
                "newDesc",
                eventStart,
                eventEnd);
        eventCtrl.addEvent(event,user);

        List<Event> listOfEvent = eventCtrl.allEvents(user);

        assert (listOfEvent != null);
        verify(eventRepository).findAll(testId);
    }
}