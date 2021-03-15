package com.immigrant.dream.contact.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ContactData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    @NotBlank(message = "Email cannot be blank")
    @ApiModelProperty(name = "email", required = true)
    private String email;

    @Column(name = "first_name")
    @NotBlank(message = "First Name cannot be blank")
    @ApiModelProperty(name = "first name", required = true)
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last Name cannot be blank")
    @ApiModelProperty(name = "last name", required = true)
    private String lastName;

    @Column(name = "message")
    @NotBlank(message = "Message cannot be blank")
    @ApiModelProperty(name = "message", required = true)
    private String message;
}
