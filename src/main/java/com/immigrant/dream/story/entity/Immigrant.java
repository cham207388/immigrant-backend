package com.immigrant.dream.story.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Immigrant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @Column(name = "profession")
    private String profession;

    @Column(name = "story")
    @NotBlank(message = "Imigrant story cannot be blank")
    private String story;

    @Column(name = "hubby")
    private String hubby;

    @Column(name = "origin")
    @NotBlank(message = "Immigrant origin cannot be blank")
    private String origin;

    public static Immigrant lowerCase(Immigrant immigrant) {
        if (StringUtils.isNotEmpty(immigrant.getFirstName())) {
            immigrant.setFirstName(StringUtils.lowerCase(immigrant.getFirstName()));
        }
        if (StringUtils.isNotEmpty(immigrant.getLastName())) {
            immigrant.setLastName(StringUtils.lowerCase(immigrant.getLastName()));
        }
        if (StringUtils.isNotEmpty(immigrant.getProfession())) {
            immigrant.setProfession(StringUtils.lowerCase(immigrant.getProfession()));
        }
        if (StringUtils.isNotEmpty(immigrant.getStory())) {
            immigrant.setStory(StringUtils.lowerCase(immigrant.getStory()));
        }
        if (StringUtils.isNotEmpty(immigrant.getHubby())) {
            immigrant.setHubby(StringUtils.lowerCase(immigrant.getHubby()));
        }
        if (StringUtils.isNotEmpty(immigrant.getOrigin())) {
            immigrant.setOrigin(StringUtils.lowerCase(immigrant.getOrigin()));
        }
        return immigrant;
    }

    public static Immigrant capitalize(Immigrant immigrant) {
        if (StringUtils.isNotEmpty(immigrant.getFirstName())) {
            immigrant.setFirstName(StringUtils.capitalize(immigrant.getFirstName()));
        }
        if (StringUtils.isNotEmpty(immigrant.getLastName())) {
            immigrant.setLastName(StringUtils.capitalize(immigrant.getLastName()));
        }
        if (StringUtils.isNotEmpty(immigrant.getProfession())) {
            immigrant.setProfession(StringUtils.capitalize(immigrant.getProfession()));
        }
        if (StringUtils.isNotEmpty(immigrant.getStory())) {
            immigrant.setStory(StringUtils.capitalize(immigrant.getStory()));
        }
        if (StringUtils.isNotEmpty(immigrant.getHubby())) {
            immigrant.setHubby(StringUtils.capitalize(immigrant.getHubby()));
        }
        if (StringUtils.isNotEmpty(immigrant.getOrigin())) {
            immigrant.setOrigin(StringUtils.capitalize(immigrant.getOrigin()));
        }
        return immigrant;
    }
}
