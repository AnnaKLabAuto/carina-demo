package com.zebrunner.carina.demo.constans;

public enum ProductDetail {
    PRODUCT_NAME1("Tank"),
    PRODUCT_NAME2("Juno Jacket"),
    COLOR_OPTION1("black"),
    COLOR_OPTION2("blue"),
    COLOR_OPTION3("gray"),
    COLOR_OPTION4("red"),
    INVALID("");

    private final String value;

    ProductDetail(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
