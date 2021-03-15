package com.immigrant.dream.contact.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("email")
@Data
public class MailConfiguration {
    private String receiverOne;
    private String receiverTwo;
    private String from;
}
