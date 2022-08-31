package com.demo.testfromsubmition.formsubmition.controllers;

import com.demo.testfromsubmition.formsubmition.data.EventsData;
import com.demo.testfromsubmition.formsubmition.models.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("events")
public class eventController {


    // this will render the index view template localhost:8080/events
    @GetMapping
    public String listOfEvents(Model model) {
        model.addAttribute("title", "List of Events");
        model.addAttribute("events", EventsData.getAllEvents());
        return "events/index";
    }

    // this will render the create view template in localhost8080:events/create
    @GetMapping("create")
    public String renderCreateFormView(Model model) {
        model.addAttribute("title", "Create Event Form");
        model.addAttribute(new Events());
        return "events/create";
    }

    // this will render the delete view template in localhost8080:events/delete
    @GetMapping("delete")
    public String renderDeleteFormView(Model model) {
        model.addAttribute("title", "Delete Event Form");
        model.addAttribute("events", EventsData.getAllEvents());
        return "events/delete";
    }

    // after submitting a form in the create view template, this will get triggered.
    // this will save the data in the form to the List of Events.
    @PostMapping("create")
//    @RequestMapping(method = { RequestMethod.POST, RequestMethod.GET}, value = "create")
    public String createEvent(@ModelAttribute @Valid Events newEvents, Errors errors, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event Form");
            return "events/create";
        }

        EventsData.addEvent(newEvents);
        return "redirect:";
    }

//    @PostMapping("create")
//    public String createEvent(@RequestParam String eventName,
//                              @RequestParam String eventDescription) {
//        EventsData.addEvent(new Events(eventName, eventDescription));
//        return "redirect:";
//    }

    @PostMapping("delete")
    public String deleteEvent(@RequestParam(required = false) Long[] eventIds) {

        for(long id : eventIds) {
            EventsData.removeEvent(id);
        }
        return "redirect:";
    }

}
