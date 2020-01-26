package ru.art.testTaskNordClan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.art.testTaskNordClan.repository.EventRepository;

@Controller
public class MainController {

    @Autowired
    EventRepository er;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("eventcalendar");
    }

}
