package com.tpuhalo.controller;

import com.tpuhalo.service.GenericWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private GenericWelcomeService genericWelcomeService;

    @RequestMapping("/")
    public String doWelcome(Model model){

        List<String> welcomeMessage = genericWelcomeService.getWelcomeMessage("Tihomir");

        model.addAttribute("myWelcomeMessage", welcomeMessage);

        return "welcomeNew";

    }
}
