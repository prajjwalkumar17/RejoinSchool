package com.rejointech.Rejoinschool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String displayLoginPage(@RequestParam(value="error",required=false)String error,
                                   @RequestParam(value="logout",required=false)String logout,
                                   Model model){
        String errorMessage=null;
        if(error!=null)
            errorMessage="username or Password incorrect!!";
        if(logout!=null)
            errorMessage="Successfully LoggedOut!!";

        log.error(errorMessage);
        model.addAttribute("errorMessge",errorMessage);
        return "login.html";
    }
    @RequestMapping(value = "/logout",method = {RequestMethod.GET})
    public String logoutUser(HttpServletRequest request, HttpServletResponse response){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null)
            new SecurityContextLogoutHandler().logout(request,response,auth);
        log.error(auth.getName());
        return "redirect:/login?logout=true";
    }}
