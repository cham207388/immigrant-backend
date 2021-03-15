package com.immigrant.dream.contact.service;

import com.immigrant.dream.contact.config.MailConfiguration;
import com.immigrant.dream.contact.entity.ContactData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailConfiguration mailConfiguration;

    public void sendEmail(ContactData contactData) {

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(mailConfiguration.getFrom());
            mailMessage.setTo(mailConfiguration.getReceiverOne());//, mailConfiguration.getReceiverTwo());

            mailMessage.setSubject("Immigrant Dream Inquire");
            mailMessage.setText("From:\t" + contactData.getEmail() +
                    "\nName:\t" + contactData.getFirstName() + " " + contactData.getLastName()
                    + "\nMessage:\t" + contactData.getMessage());

            javaMailSender.send(mailMessage);
            log.info("Email is successfully sent!");
        } catch (Exception exception) {
            log.info(exception.getMessage());
        }
    }
}
