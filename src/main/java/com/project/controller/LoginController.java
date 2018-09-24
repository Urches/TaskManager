package com.project.controller;

import com.project.common.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody User user) {

    }

    @RequestMapping("/test")
    public String test() {
        System.out.println("Test!");
        return "Test!";
    }
}
