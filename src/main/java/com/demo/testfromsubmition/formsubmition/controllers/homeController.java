package com.demo.testfromsubmition.formsubmition.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping()
    public String homeController(Model model) {
        model.addAttribute("title", "Coding Event");
        return "index";
    }
}
