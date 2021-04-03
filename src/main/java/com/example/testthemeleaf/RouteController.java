package com.example.testthemeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class RouteController {

    @GetMapping("/home")
    public String home() {
        return "page/home";
    }

    @GetMapping("/user")
    public String user() {
        return "page/user";
    }
}
