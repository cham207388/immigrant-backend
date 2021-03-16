package com.immigrant.dream.story.controller;

import com.immigrant.dream.exception.ImmigrantException;
import com.immigrant.dream.story.entity.Immigrant;
import com.immigrant.dream.story.service.ImmigrantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/stories")
public class ImmigrantControllerImpl {

    @Autowired
    private ImmigrantService immigrantService;

    @ApiOperation(value = "find all immigrants")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Immigrant> findAll(){
        return immigrantService.findAll();
    }

    @ApiOperation(value = "find all immigrant by profession")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = List.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    @GetMapping(path = "/profession/{profession}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Immigrant> findAllByPrefession(@PathVariable String profession){
        return immigrantService.findAllByProfession(profession);
    }

    @ApiOperation(value = "find an immigrant by first and last name")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = Immigrant.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    @GetMapping(path = "/story/firstName/{firstName}/lastName/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Immigrant findByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return immigrantService.findByFirstNameAndLastName(firstName, lastName);
    }

    @ApiOperation(value = "save an immigrant")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Success", response = Immigrant.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request", response = ImmigrantException.class)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Immigrant save(@RequestBody Immigrant immigrant){
        return immigrantService.save(immigrant);
    }
}
