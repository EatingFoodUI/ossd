package com.lyl.springboot.ossd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hello {
    @RequestMapping("/")
    public String hello(){
        System.out.println("hello");
        return "/index1";
    }

    @RequestMapping("/string")
    public String string(ModelMap map){
        map.addAttribute("userName", "ityouknow");
        System.out.println("111");
        return "index1";
    }
}
