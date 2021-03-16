package com.immigrant.dream.story.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmigrantTest {
    private static final Immigrant classUnderTest = new Immigrant();
    private static final Long ID = 1L;
    private static final String FIRST_NAME = "john";
    private static final String LAST_NAME = "johnson";
    private static final String PROFESSION = "engineer";
    private static final String STORY = "story";
    private static final String HUBBY = "reading";
    private static final String ORIGIN = "the gambia";

    @Test
    void capitalize() {
        assertNotNull(Immigrant.capitalize(immigrant()));
    }

    @Test
    void testId() {
        classUnderTest.setId(ID);
        assertEquals(ID, classUnderTest.getId());
    }

    @Test
    void testFirstName() {
        classUnderTest.setFirstName(FIRST_NAME);
        assertEquals(FIRST_NAME, classUnderTest.getFirstName());
    }

    @Test
    void testLastName() {
        classUnderTest.setLastName(LAST_NAME);
        assertEquals(LAST_NAME, classUnderTest.getLastName());
    }

    @Test
    void testProfession() {
        classUnderTest.setProfession(PROFESSION);
        assertEquals(PROFESSION, classUnderTest.getProfession());
    }

    @Test
    void testStory() {
        classUnderTest.setStory(STORY);
        assertEquals(STORY, classUnderTest.getStory());
    }

    @Test
    void testHubby() {
        classUnderTest.setHubby(HUBBY);
        assertEquals(HUBBY, classUnderTest.getHubby());
    }

    @Test
    void testOrigin() {
        classUnderTest.setOrigin(ORIGIN);
        assertEquals(ORIGIN, classUnderTest.getOrigin());
    }

    private Immigrant immigrant() {
        Immigrant immigrant = new Immigrant();
        immigrant.setFirstName(FIRST_NAME);
        immigrant.setLastName(LAST_NAME);
        immigrant.setProfession(PROFESSION);
        immigrant.setStory(STORY);
        immigrant.setHubby(HUBBY);
        immigrant.setOrigin(ORIGIN);
        return immigrant;
    }
}