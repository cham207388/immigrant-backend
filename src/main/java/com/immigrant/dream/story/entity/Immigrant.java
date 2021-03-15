package com.immigrant.dream.story.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@ApiModel(description = "recipe object")
public class Immigrant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "First name cannot be blank")
    @ApiModelProperty(name = "first name", required = true)
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name cannot be blank")
    @ApiModelProperty(name = "last name", required = true)
    private String lastName;

    @Column(name = "profession")
    @ApiModelProperty(name = "profession")
    private String profession;

    @Column(name = "story")
    @NotBlank(message = "Imigrant story cannot be blank")
    @ApiModelProperty(name = "story", required = true)
    private String story;

    @Column(name = "hubby")
    @ApiModelProperty(name = "hubby")
    private String hubby;

    @Column(name = "origin")
    @NotBlank(message = "Immigrant origin cannot be blank")
    @ApiModelProperty(name = "origin", required = true)
    private String origin;

    public static Immigrant toLowerCase(Immigrant immigrant){
        if (StringUtils.isEmpty(immigrant.getFirstName())){
            immigrant.setFirstName(immigrant.getFirstName().toLowerCase());
        }
        if (StringUtils.isEmpty(immigrant.getLastName())){
            immigrant.setLastName(immigrant.getLastName().toLowerCase());
        }
        if (StringUtils.isEmpty(immigrant.getProfession())){
            immigrant.setProfession(immigrant.getProfession().toLowerCase());
        }
        if (StringUtils.isEmpty(immigrant.getStory())){
            immigrant.setStory(immigrant.getStory().toLowerCase());
        }
        if (StringUtils.isEmpty(immigrant.getHubby())){
            immigrant.setHubby(immigrant.getHubby().toLowerCase());
        }
        if (StringUtils.isEmpty(immigrant.getOrigin())){
            immigrant.setOrigin(immigrant.getOrigin().toLowerCase());
        }
        return immigrant;
    }
}
