package com.immigrant.dream.contact.controller;

import com.immigrant.dream.contact.entity.ContactData;
import com.immigrant.dream.contact.service.ContactDataService;
import com.immigrant.dream.exception.ImmigrantException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Api(tags = "Contact Data API")
@RestController
@RequestMapping(path = "/contact-data")
public class ContactDataControllerImpl implements ContactDataController {

    @Autowired
    private ContactDataService contactDataService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ContactData save(@RequestBody @Valid ContactData contactData){
        return contactDataService.save(contactData);
    }

    @Override
    @ApiOperation(value = "save contact data of inquirer")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = ContactData.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ContactData> findAll(){
        return contactDataService.findAll();
    }
}
