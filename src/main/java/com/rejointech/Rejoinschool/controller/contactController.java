package com.rejointech.Rejoinschool.controller;
import com.rejointech.Rejoinschool.model.Contact;
import com.rejointech.Rejoinschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Slf4j
public class contactController {
    private ContactService contactService;

    @Autowired
    public contactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value="/contact")
    public String contactController(Model model){
        model.addAttribute("contact",new Contact());
        return "contact";
    }
//    @PostMapping(value="/saveMsg")
//    public ModelAndView saveMessage(@RequestParam String name,@RequestParam String mobileNum,
//                                    @RequestParam String email,@RequestParam String subject,
//                                    @RequestParam String message)
//    {
//        log.info("Name : "+name);
//        log.info("mobileNum : "+mobileNum);
//        log.info("email : "+email);
//        log.info("subject : "+subject);
//        log.info("message : "+message);
//        return new ModelAndView("redirect:/contact");
//    }
    @PostMapping("/saveMsg")
    public String contactController(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("contact form validation failed due to : "+errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
}
