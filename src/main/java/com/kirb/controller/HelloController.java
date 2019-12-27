package com.kirb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("hello")
    public String hello(Model m){
        m.addAttribute("name","jiodsjjfa");
        return "hello";
    }
}
