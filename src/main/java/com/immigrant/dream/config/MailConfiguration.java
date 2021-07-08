package com.immigrant.dream.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("email")
@Getter
@Setter
public class MailConfiguration {
    private String receiverOne;
    private String receiverTwo;
    private String from;
}
