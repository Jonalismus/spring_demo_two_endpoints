package com.example.spring_demo_two_endpoints.controller;

import com.example.spring_demo_two_endpoints.service.StringService;
import org.springframework.web.bind.annotation.*;

//first endpoint that transmits a string that the service must remember

@RestController
@RequestMapping("/api")
public class StoreStringController {

    private final StringService stringService;

    public StoreStringController(StringService stringService){
        this.stringService = stringService;
    }

    @PostMapping("/storeString")
    public void storeString(@RequestBody String input) {
        stringService.setStoredString(input);
    }

}
