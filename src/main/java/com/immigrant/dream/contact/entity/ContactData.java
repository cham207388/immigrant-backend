package com.immigrant.dream.contact.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ContactData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Column(name = "first_name")
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;

    @Column(name = "message")
    @NotBlank(message = "Message cannot be blank")
    private String message;
}
