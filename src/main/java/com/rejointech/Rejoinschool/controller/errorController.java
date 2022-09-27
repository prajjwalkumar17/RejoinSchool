package com.rejointech.Rejoinschool.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class errorController {
    @RequestMapping("/error")
    public String errorController(){
        return "error.html";
    }
}
