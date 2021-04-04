package com.example.testthemeleaf;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/page")
public class RouteController {

    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        request.setAttribute("hello", "fewawfefeawwfe");
        return "/page/home";
    }

    @GetMapping("/uploadPage")
    public String uploadPage() {
        return "page/upload";
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
        return "/page/user";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam Integer id, @RequestParam String name) {
        System.out.println("DELETE USER: id = " + id);
        System.out.println("DELETE USER: name = " + name);
        return "forward:/page/user";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam Integer id, @RequestParam String name) {
        System.out.println("UPDATE USER: id = " + id);
        System.out.println("UPDATE USER: name = " + name);
        return "redirect:/page/user";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(
            @RequestParam String fname, @RequestParam String lname,
            @RequestParam("logo") MultipartFile logoFile, ModelMap modelMap) {
        System.out.println("uploadFile: fname = " + fname);
        System.out.println("uploadFile: lname = " + lname);
        String originalFilename = logoFile.getOriginalFilename();
        System.out.println(originalFilename);
        System.out.println(FilenameUtils.getExtension(originalFilename));
        File target = new File("C:\\Users\\thedoflin\\Downloads\\1.hello");
        if (!logoFile.isEmpty()) {
            try {
                logoFile.transferTo(target);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        modelMap.put("errorMessage", "errorMessagekfweaawef23f32");
        return "/page/upload";
    }
}
