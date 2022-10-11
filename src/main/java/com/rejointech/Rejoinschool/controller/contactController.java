package com.rejointech.Rejoinschool.controller;
import com.rejointech.Rejoinschool.model.Contact;
import com.rejointech.Rejoinschool.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class contactController {
    private static Logger log= LoggerFactory.getLogger(contactController.class);
    private ContactService contactService;

    @Autowired
    public contactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value="/contact")
    public String contactController(){
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
    public ModelAndView contactController(Contact contact){
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
