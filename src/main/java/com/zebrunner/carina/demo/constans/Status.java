package com.zebrunner.carina.demo.constans;

public enum Status {
    SUCCESS("success"),
    FAIL("fail");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
