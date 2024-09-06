package com.java.bootjsonvalidator.dto.filter;

public enum FileStatusType {
    INVALID_USER("INVALID_USER"),
    INVALID_ADDRESS("INVALID_ADDRESS"),
    INVALID_EMPTY("INVALID_EMPTY"),
    INVALID_FILE("INVALID_FILE"),
    TEST("TEST");


    private String type;

    FileStatusType(String type) {
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
