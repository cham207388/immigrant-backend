package com.immigrant.dream.business.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Business {

    @Id
    private Long id;

    @Column(name = "business_name")
    @NotBlank(message = "Business name cannot be blank")
    private String businessName;

    @Column(name = "business_description")
    @NotBlank(message = "Business description cannot be blank")
    private String businessDescription;

    @Column(name = "business_location")
    @NotBlank(message = "Business location cannot be blank")
    private String businessLocation;

    @Column(name = "business_products")
    private String businessProducts;

    @Column(name = "business_site")
    private String businessSite;

    @Column(name = "business_type")
    private String businessType;

}
