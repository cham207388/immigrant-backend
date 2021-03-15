package com.immigrant.dream.story.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
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
}
