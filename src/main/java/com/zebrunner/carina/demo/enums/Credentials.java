package com.zebrunner.carina.demo.enums;

public enum Credentials {
    EMAIL("thomas.smith@email.com"),
    PASSWORD("password123!@#");

    private String credential;

    Credentials(String credential) {
        this.credential = credential;
    }

    public String getStatus() {
        return credential;
    }
}
