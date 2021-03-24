package com.immigrant.dream.business.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Business {

    @Id
    private Long id;

    @Column(name = "business_name", nullable = false)
    @NotBlank(message = "Business name cannot be blank")
    @ApiModelProperty(name = "business name")
    private String name;

    @Column(name = "business_description")
    @NotBlank(message = "Business description cannot be blank")
    @ApiModelProperty(name = "business description", required = true)
    private String description;

    @Column(name = "business_location")
    @NotBlank(message = "Business location cannot be blank")
    @ApiModelProperty(name = "business location", required = true)
    private String location;

    @Column(name = "business_site")
    @ApiModelProperty(name = "business website")
    private String site;

    @Column(name = "business_type")
    @ApiModelProperty(name = "the type of business")
    private String type;

    public static Business lowercase(Business business) {
        if (StringUtils.isNotEmpty(business.getName())) {
            business.setName(StringUtils.lowerCase(business.getName()));
        }
        if (StringUtils.isNotEmpty(business.getDescription())) {
            business.setDescription(StringUtils.lowerCase(business.getDescription()));
        }
        if (StringUtils.isNotEmpty(business.getLocation())) {
            business.setLocation(StringUtils.lowerCase(business.getLocation()));
        }
        if (StringUtils.isNotEmpty(business.getSite())) {
            business.setSite(StringUtils.lowerCase(business.getSite()));
        }
        if (StringUtils.isNotEmpty(business.getType())) {
            business.setType(StringUtils.lowerCase(business.getType()));
        }
        return business;
    }

    public static Business capitalize(Business business) {
        if (!StringUtils.isEmpty(business.getName())) {
            business.setName(StringUtils.capitalize(business.getName()));
        }
        if (!StringUtils.isEmpty(business.getDescription())) {
            business.setDescription(StringUtils.capitalize(business.getDescription()));
        }
        if (!StringUtils.isEmpty(business.getLocation())) {
            business.setLocation(StringUtils.capitalize(business.getLocation()));
        }
        if (!StringUtils.isEmpty(business.getSite())) {
            business.setSite(StringUtils.capitalize(business.getSite()));
        }
        if (!StringUtils.isEmpty(business.getType())) {
            business.setType(StringUtils.capitalize(business.getType()));
        }
        return business;
    }
}
