package com.zebrunner.carina.demo.enums;

public enum Credentials {
    EMAIL("thomas.smith@email.com"),
    PASSWORD("password123!@#"),
    NAME("Thomas Smith"),
    INVALID(" ");

    private final String value;

    Credentials (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
