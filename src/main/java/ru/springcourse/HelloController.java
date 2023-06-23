package ru.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class HelloController {

    @GetMapping("/hello-world")
    public String sayHello(){
        Logger.getAnonymousLogger().info("Test log");
        return "hello_world";
    }
}
