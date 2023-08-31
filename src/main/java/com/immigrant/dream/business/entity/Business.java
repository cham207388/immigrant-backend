package com.immigrant.dream.business.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Business {

    @Id
    private Long id;

    @Column(name = "business_name", nullable = false)
    @NotBlank(message = "Business name cannot be blank")
    private String businessName;

    @Column(name = "business_description")
    @NotBlank(message = "Business description cannot be blank")
    private String businessDescription;

    @Column(name = "business_location")
    @NotBlank(message = "Business location cannot be blank")
    private String businessLocation;

    @Column(name = "business_site")
    private String businessSite;

    @Column(name = "business_type")
    private String businessType;

    public static Business lowercase(Business business) {
        if (StringUtils.isNotEmpty(business.getBusinessName())) {
            business.setBusinessName(StringUtils.lowerCase(business.getBusinessName()));
        }
        if (StringUtils.isNotEmpty(business.getBusinessDescription())) {
            business.setBusinessDescription(StringUtils.lowerCase(business.getBusinessDescription()));
        }
        if (StringUtils.isNotEmpty(business.getBusinessLocation())) {
            business.setBusinessLocation(StringUtils.lowerCase(business.getBusinessLocation()));
        }
        if (StringUtils.isNotEmpty(business.getBusinessSite())) {
            business.setBusinessSite(StringUtils.lowerCase(business.getBusinessSite()));
        }
        if (StringUtils.isNotEmpty(business.getBusinessType())) {
            business.setBusinessType(StringUtils.lowerCase(business.getBusinessType()));
        }
        return business;
    }

    public static Business capitalize(Business business) {
        if (!StringUtils.isEmpty(business.getBusinessName())) {
            business.setBusinessName(StringUtils.capitalize(business.getBusinessName()));
        }
        if (!StringUtils.isEmpty(business.getBusinessDescription())) {
            business.setBusinessDescription(StringUtils.capitalize(business.getBusinessDescription()));
        }
        if (!StringUtils.isEmpty(business.getBusinessLocation())) {
            business.setBusinessLocation(StringUtils.capitalize(business.getBusinessLocation()));
        }
        if (!StringUtils.isEmpty(business.getBusinessSite())) {
            business.setBusinessSite(StringUtils.capitalize(business.getBusinessSite()));
        }
        if (!StringUtils.isEmpty(business.getBusinessType())) {
            business.setBusinessType(StringUtils.capitalize(business.getBusinessType()));
        }
        return business;
    }
}
