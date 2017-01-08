package com.cristto.controller;

import com.cristto.model.AppUser;
import com.cristto.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    AppUserService appUserService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/addUser")
    public String addUser() {
        appUserService.insertAppUser(new AppUser("Ines", "87654321"));
        return "home";
    }
}
