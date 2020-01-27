package ru.art.testTaskNordClan.controller;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.art.testTaskNordClan.model.Event;
import ru.art.testTaskNordClan.repository.EventRepository;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {
    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    EventController eventCtrl;

    @Test
    public void allEvents() {
//        when(eventRepository.findAll()).thenReturn(ImmutableList.of());
//        List<Event> listOfEvent = eventCtrl.allEvents();
//        verify(eventRepository).findAll();
    }

    @Test
    public void removeEvent() {
    }

    @Test
    public void addEvent() {
    }
}