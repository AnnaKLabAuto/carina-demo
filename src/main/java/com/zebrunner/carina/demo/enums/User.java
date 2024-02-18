package com.zebrunner.carina.demo.enums;

public enum User {
    USER("bob@example.com"),
    PASSWORD("10203040"),
    INVALID("");

    private final String value;

    User(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
