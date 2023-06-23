package ru.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        System.out.println("Hello, " + request.getParameter("name") + " " + request.getParameter("surname") +"!");
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "surname", required = false) String surname,
                                Model model){
        model.addAttribute("message", "Goodbye, " + name + " " + surname + "!");
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(
            @RequestParam(value = "a") double a,
            @RequestParam(value = "b") double b,
            @RequestParam(value = "action") String action,
            Model model
    ) {
        Double calcResult = null;
        switch (action) {
            case "multiplication":
                calcResult = a * b;
                break;
            case "addiction":
                calcResult = a + b;
                break;
            case "subtraction":
                calcResult = a - b;
                break;
            case "division":
                calcResult = a/b;
        }
        model.addAttribute("result", "Result of " + action + " " + a + " and " + b + " is " + calcResult);
        return "/first/calculator";
    }
}
