package com.example.spring_demo_two_endpoints.service;

import org.springframework.stereotype.Service;

@Service
public class StringService {

    private String storedString;

    public void setStoredString(String storedString) {
        this.storedString = storedString;
    }

    public StringInfo getStringInfo(){
        StringInfo stringInfo = new StringInfo();
        stringInfo.setStoredString(storedString);
        stringInfo.setNumericOnly(isNumericOnly(storedString));
        stringInfo.setWhitespaceTupelsCount(countWhitespaceTupels(storedString));
        return stringInfo;
    }

    protected boolean isNumericOnly(String str) {
        return str != null && str.matches("\\d+");
    }

    protected int countWhitespaceTupels(String str) {
        return str != null ? str.split("\\s+").length : 0;
    }
}
