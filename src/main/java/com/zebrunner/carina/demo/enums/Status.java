package com.zebrunner.carina.demo.enums;

public enum Status {
    SUCCESS("success"),
    FAIL("fail");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
