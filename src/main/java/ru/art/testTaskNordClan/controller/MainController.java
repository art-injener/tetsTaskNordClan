package ru.art.testTaskNordClan.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.art.testTaskNordClan.model.Event;
import ru.art.testTaskNordClan.repository.EventRepository;

import java.time.LocalDateTime;

@Controller
public class MainController {

    @Autowired
    EventRepository er;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("eventcalendar");
    }

}
