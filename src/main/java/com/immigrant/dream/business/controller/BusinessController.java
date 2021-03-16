package com.immigrant.dream.business.controller;

import com.immigrant.dream.business.entity.Business;
import com.immigrant.dream.exception.ImmigrantException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface BusinessController {
    @ApiOperation(value = "find a business by id")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = Business.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    @GetMapping(path = "/business/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    Business findById(@PathVariable Long id);

    @ApiOperation(value = "find a business by name")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = Business.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    @GetMapping(path = "/business/businessName/{businessName}",produces = MediaType.APPLICATION_JSON_VALUE)
    Business findByBusinessName(@PathVariable String businessName);

    @ApiOperation(value = "find all businesses")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Business> findAll();

    @ApiOperation(value = "find all businesses by type")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    @GetMapping(path = "/businessType/{businessType}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Business> findAllByBusinessType(@PathVariable String businessType);
}
