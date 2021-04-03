package com.example.testthemeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/page")
public class RouteController {

    @GetMapping("/home")
    public String home() {
        return "page/home";
    }

    @GetMapping("/navigation")
    public String navigation() {
        return "page/navigation";
    }

    @GetMapping("/user")
    public String user(ModelMap modelMap) {
        String logo = "https://postimgs.org/img/bookshelf.jpg";
        User u1 = new User(1, "ffawef", logo, new Date());
        User u2 = new User(2, "34t3g4r", logo, new Date());
        User u3 = new User(3, "g34f34fawe", logo, new Date());
        List<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        modelMap.put("userList", userList);
        return "page/user";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam Integer id, @RequestParam String name) {
        System.out.println("DELETE USER: id = " + id);
        System.out.println("DELETE USER: name = " + name);
        return "redirect:user";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam Integer id, @RequestParam String name) {
        System.out.println("UPDATE USER: id = " + id);
        System.out.println("UPDATE USER: name = " + name);
        return "redirect:user";
    }
}
