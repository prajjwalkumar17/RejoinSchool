package com.rejointech.Rejoinschool.controller;
import com.rejointech.Rejoinschool.model.Contact;
import com.rejointech.Rejoinschool.repository.ContactRepo;
import com.rejointech.Rejoinschool.service.ContactService;
import com.rejointech.Rejoinschool.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

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
    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model){
        List<Contact> contactMsg=contactService.findMsgWithOpenStatus();
        ModelAndView modelAndView=new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs",contactMsg);
        return modelAndView;
    }
    @RequestMapping(value="/closeMsg",method = RequestMethod.GET)
    public String closeMsg(@RequestParam int id, Authentication authentication){
        contactService.updateMsgStatus(id,authentication.getName());
        return "redirect:/displayMessages";
    }
}
