package com.example.spring_demo_two_endpoints.service;

public class StringInfo {

    private String storedString;
    private int whitespaceTupelsCount;
    private boolean numericOnly;

    //Getter and Setter
    public String getStoredString() {
        return storedString;
    }
    public void setStoredString(String storedString) {
        this.storedString = storedString;
    }

    public int getWhitespaceTupelsCount() {
        return whitespaceTupelsCount;
    }
    public void setWhitespaceTupelsCount(int whitespaceTupelsCount) {
        this.whitespaceTupelsCount = whitespaceTupelsCount;
    }

    public boolean isNumericOnly() {
        return numericOnly;
    }
    public void setNumericOnly(boolean numericOnly) {
        this.numericOnly = numericOnly;
    }
}
