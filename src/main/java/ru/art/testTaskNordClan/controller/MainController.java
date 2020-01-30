package ru.art.testTaskNordClan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.art.testTaskNordClan.repository.EventRepository;

/**
 * Сontroller class for mapping request from frontend
 * @author Danilchenko Artem
 */
@Controller
public class MainController {

    @Autowired
    private  EventRepository eventRepo;

    /** redirect root request to main page */
    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("eventcalendar");
    }

}
