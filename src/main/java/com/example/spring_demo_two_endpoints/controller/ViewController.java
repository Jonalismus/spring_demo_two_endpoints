package com.example.spring_demo_two_endpoints.controller;

import com.example.spring_demo_two_endpoints.service.StringInfo;
import com.example.spring_demo_two_endpoints.service.StringService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// rendering the HTML view

@Controller
public class ViewController {

    private final StringService stringService;

    public ViewController(StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping("/") // Processes GET requests to the root URL (/).
    public String showForm(Model model) {
        model.addAttribute("stringInfo", new StringInfo()); // Adds a new StringInfo object to the model
        return "index";
    }

    @PostMapping("/storeString") // Processes POST requests to /storeString
    public String storeString(@ModelAttribute StringInfo stringInfo) { // binds the form parameters to the StringInfo object
        stringService.setStoredString(stringInfo.getStoredString());
        return "redirect:/getStringInfo"; // Redirects the user to the /getStringInfo endpoint to display the stored information
    }

    @GetMapping("/getStringInfo")
    public String getStringInfo(Model model) {
        StringInfo stringInfo = stringService.getStringInfo();
        model.addAttribute("stringInfo", stringInfo);
        return "info";
    }
}
