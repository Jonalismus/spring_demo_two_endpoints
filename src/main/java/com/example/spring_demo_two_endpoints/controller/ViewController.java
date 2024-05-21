package com.example.spring_demo_two_endpoints.controller;

import com.example.spring_demo_two_endpoints.service.StringInfo;
import com.example.spring_demo_two_endpoints.service.StringService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    private final StringService stringService;

    public ViewController(StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("stringInfo", new StringInfo());
        return "index";
    }

    @PostMapping("/storeString")
    public String storeString(@ModelAttribute StringInfo stringInfo) {
        stringService.setStoredString(stringInfo.getStoredString());
        return "redirect:/getStringInfo";
    }

    @GetMapping("/getStringInfo")
    public String getStringInfo(Model model) {
        StringInfo stringInfo = stringService.getStringInfo();
        model.addAttribute("stringInfo", stringInfo);
        return "info";
    }
}
