package com.immigrant.dream.business.entity;

import io.swagger.annotations.ApiModelProperty;
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

    @Column(name = "business_name", nullable = false)
    @NotBlank(message = "Business name cannot be blank")
    @ApiModelProperty(name = "business name")
    private String businessName;

    @Column(name = "business_description")
    @NotBlank(message = "Business description cannot be blank")
    @ApiModelProperty(name = "business description", required = true)
    private String businessDescription;

    @Column(name = "business_location")
    @NotBlank(message = "Business location cannot be blank")
    @ApiModelProperty(name = "business location", required = true)
    private String businessLocation;

    @Column(name = "business_products")
    @ApiModelProperty(name = "business products")
    private String businessProducts;

    @Column(name = "business_site")
    @ApiModelProperty(name = "business website")
    private String businessSite;

    @Column(name = "business_type")
    @ApiModelProperty(name = "the type of business")
    private String businessType;

}
