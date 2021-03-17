package com.immigrant.dream.story.controller;

import com.immigrant.dream.exception.ImmigrantException;
import com.immigrant.dream.story.entity.Immigrant;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ImmigrantController {
    @ApiOperation(value = "find all immigrants")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    List<Immigrant> findAll();

    @ApiOperation(value = "find all immigrant by profession")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    List<Immigrant> findAllByPrefession(@PathVariable String profession);

    @ApiOperation(value = "find all immigrant by profession")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    Immigrant findById(@PathVariable Long id);

    @ApiOperation(value = "find an immigrant by first and last name")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = Immigrant.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    Immigrant findByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName);

    @ApiOperation(value = "save an immigrant")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = Immigrant.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    Immigrant save(@RequestBody Immigrant immigrant);

    @ApiOperation(value = "save an immigrant")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = Immigrant.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    List<Immigrant> saveAll(@RequestBody List<Immigrant> immigrant);
}
