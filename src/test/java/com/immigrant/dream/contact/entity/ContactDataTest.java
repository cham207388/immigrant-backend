package com.immigrant.dream.contact.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactDataTest {
    private static final ContactData classUnderTest = new ContactData();
    private static final String FIRST_NAME = "john";
    private static final String LAST_NAME = "johnson";
    private static final String EMAIL = "engineer";
    private static final String MESSAGE = "story";
    private static final Long ID = 1L;

    @Test
    void getId() {
        classUnderTest.setId(ID);
        assertEquals(ID, classUnderTest.getId());
    }

    @Test
    void getEmail() {
        classUnderTest.setEmail(EMAIL);
        assertEquals(EMAIL, classUnderTest.getEmail());
    }

    @Test
    void getFirstName() {
        classUnderTest.setFirstName(FIRST_NAME);
        assertEquals(FIRST_NAME, classUnderTest.getFirstName());
    }

    @Test
    void getLastName() {
        classUnderTest.setLastName(LAST_NAME);
        assertEquals(LAST_NAME, classUnderTest.getLastName());
    }

    @Test
    void getMessage() {
        classUnderTest.setMessage(MESSAGE);
        assertEquals(MESSAGE, classUnderTest.getMessage());
    }
}