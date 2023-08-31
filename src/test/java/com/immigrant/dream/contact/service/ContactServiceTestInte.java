package com.immigrant.dream.contact.service;

import com.immigrant.dream.contact.entity.ContactData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author by Alhagie Bai Cham
 * @date 1/24/22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactServiceTestInte {

    @Autowired
    private ContactDataService contactDataService;

    @Test
    public void testSave() {
        ContactData save = contactDataService.save(contactData());
        System.out.println("save = " + save);
    }

    private ContactData contactData() {
        ContactData contactData = new ContactData();
        contactData.setEmail("cham@email.cm");
        contactData.setFirstName("Alhagie Bai");
        contactData.setLastName("Cham");
        contactData.setMessage("Unit test");

        return contactData;
    }

}