package com.rejointech.Rejoinschool.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GLobalExceptionHandling {

@ExceptionHandler(Exception.class)
public ModelAndView handler(Exception e){
        ModelAndView errorPage=new ModelAndView();
        errorPage.setViewName("error");
        errorPage.addObject("errorMessage",e.getMessage());
        return errorPage;
    }
}
