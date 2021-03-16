package com.immigrant.dream.business.controller;

import com.immigrant.dream.business.entity.Business;
import com.immigrant.dream.exception.ImmigrantException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface BusinessController {
    @ApiOperation(value = "find a business by id")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = Business.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    Business findById(@PathVariable Long id);

    @ApiOperation(value = "find a business by name")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = Business.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    Business findByBusinessName(@PathVariable String businessName);

    @ApiOperation(value = "find all businesses")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    List<Business> findAll();

    @ApiOperation(value = "find all businesses by type")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    List<Business> findAllByBusinessType(@PathVariable String businessType);

    @ApiOperation(value = "save a business")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    Business save(@RequestBody Business business);

    @ApiOperation(value = "save list of businesses")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    List<Business> saveAll(@RequestBody List<Business> business);
}
