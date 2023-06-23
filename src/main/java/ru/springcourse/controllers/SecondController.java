package ru.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
    @GetMapping("/second/exit")
    public String exit(){
        return "second/exit";
    }
}
