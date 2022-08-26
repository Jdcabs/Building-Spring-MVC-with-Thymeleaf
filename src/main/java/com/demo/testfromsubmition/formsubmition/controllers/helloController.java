package com.demo.testfromsubmition.formsubmition.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class helloController {

    // This will return a dynamic message to the browser.
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "friend")
    public String sayHello(@RequestParam String name, Model model) {
        String theGreeting = "Hello there new friend " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }
    
    // This will return a dynamic message to the browser.
    // Dynamic which means that the value will be inputted by the user in the URL.
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloUser")
    @ResponseBody
    public String userHello(@RequestParam String userName){
        return "Hello There " + userName;
    }

    // This will take the message that is inputted to the field, then it will be referenced to the parameter userName.
    // Once you click submit button, it will then call the userHello Method to display the inputted message or word
    @GetMapping("/form")
    public String submitForm() {
        return "demo1/form";
    }

    // Just created some list of names to show how Thymeleaf handle list of names.
    @GetMapping("name-list")
    public String nameList(Model model) {
        List<String> names = new ArrayList<>(Arrays.asList("john","david","cabal"));
        model.addAttribute("names", names);
        return "demo1/name-list";
    }
}
 