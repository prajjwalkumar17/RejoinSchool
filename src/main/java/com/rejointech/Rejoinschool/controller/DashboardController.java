package com.rejointech.Rejoinschool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class DashboardController{
    @RequestMapping("/dashboard")
    public String displayDashboard(Model model,Authentication auth){
        model.addAttribute("username",auth.getName());
        model.addAttribute("roles",auth.getAuthorities().toString());
        throw new RuntimeException("Its a bad day");
//        return "dashboard.html";
    }

}
