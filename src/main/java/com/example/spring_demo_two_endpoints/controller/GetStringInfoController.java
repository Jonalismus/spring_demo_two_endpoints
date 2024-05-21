package com.example.spring_demo_two_endpoints.controller;

import com.example.spring_demo_two_endpoints.service.StringInfo;
import com.example.spring_demo_two_endpoints.service.StringService;
import org.springframework.web.bind.annotation.*;

/*
Second endpoint that returns a JSON document with the following information:

- the string passed to the first endpoint
- a Boolean whether the string contains only numbers
- number of tuples separated by whitespaces

 */

@RestController
@RequestMapping("/api")
public class GetStringInfoController {

    private final StringService stringService;

    public GetStringInfoController(StringService stringService){
        this.stringService = stringService;
    }

    @GetMapping("getStringInfo")
    public StringInfo getStringInfo(){
        return stringService.getStringInfo();
    }

}
