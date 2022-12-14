package com.rejointech.Rejoinschool.service;

import com.rejointech.Rejoinschool.controller.contactController;
import com.rejointech.Rejoinschool.model.Contact;
import com.rejointech.Rejoinschool.repository.ContactRepo;
import com.rejointech.Rejoinschool.util.Constants;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@SessionScope
public class ContactService {
    @Autowired
    private ContactRepo contactRepo;
    public ContactService(){
        System.out.println("Contact Service class initialized");
    }
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=false;
        contact.setStatus(Constants.OPEN);
        contact.setCreatedBy(Constants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result=contactRepo.saveContactMsg(contact);
        if(result>0)
            isSaved=true;
        return isSaved;
    }

    public List<Contact> findMsgWithOpenStatus(){
        List<Contact> contactMsgs= ContactRepo.findMsgWithStatus(Constants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int id, String updatedBy) {
        boolean isUpdated=false;
        int result=contactRepo.updatedMsgStatus(id,Constants.CLOSE,updatedBy);
        if(result>0)isUpdated=true;
        return isUpdated;

    }
}

