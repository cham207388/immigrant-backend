package com.immigrant.dream.contact.controller;

import com.immigrant.dream.contact.entity.ContactData;
import com.immigrant.dream.exception.ImmigrantException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

public interface ContactDataController {
    @ApiOperation(value = "save contact data of inquirer")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = ContactData.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    ContactData save(@RequestBody @Valid ContactData contactData);

    @ApiOperation(value = "get everyone who contacted us")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    List<ContactData> findAll();
}
