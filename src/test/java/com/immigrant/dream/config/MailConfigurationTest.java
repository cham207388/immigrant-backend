package com.immigrant.dream.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailConfigurationTest {
    private final MailConfiguration mailConfiguration = new MailConfiguration();
    private static final String RECEIVER_ONE = "test@one.com";
    private static final String RECEIVER_TWO = "test@two.com";
    private static final String FROM = "test@from.com";

    @Test
    void testReceiverOne() {
        mailConfiguration.setReceiverOne(RECEIVER_ONE);
        assertEquals(RECEIVER_ONE, mailConfiguration.getReceiverOne());
    }

    @Test
    void testReceiverTwo() {
        mailConfiguration.setReceiverTwo(RECEIVER_TWO);
        assertEquals(RECEIVER_TWO, mailConfiguration.getReceiverTwo());
    }

    @Test
    void testFrom() {
        mailConfiguration.setFrom(FROM);
        assertEquals(FROM, mailConfiguration.getFrom());
    }
}