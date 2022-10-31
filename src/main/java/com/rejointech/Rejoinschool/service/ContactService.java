package com.rejointech.Rejoinschool.service;

import com.rejointech.Rejoinschool.controller.contactController;
import com.rejointech.Rejoinschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@Service
@SessionScope
public class ContactService {
    /*
     * Save Contact details into DB
     * @Param Contact
     * @return boolean
     * */
    private int counter=0;
    public ContactService(){
        System.out.println("Contact Service class initialized");
    }
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=true;
        log.info(contact.toString());
        return isSaved;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

