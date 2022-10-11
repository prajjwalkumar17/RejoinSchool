package com.rejointech.Rejoinschool.service;

import com.rejointech.Rejoinschool.controller.contactController;
import com.rejointech.Rejoinschool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    /*
    * Save Contact details into DB
    * @Param Contact
    * @return boolean
    * */
    private static Logger log= LoggerFactory.getLogger(contactController.class);
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=true;
        System.out.println("hello");
        log.info(contact.toString());
        return isSaved;
    }
}
