package com.springboot.section06springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model theModel){


        theModel.addAttribute("theDate", new Date());

        return "helloWorld";
    }
}
