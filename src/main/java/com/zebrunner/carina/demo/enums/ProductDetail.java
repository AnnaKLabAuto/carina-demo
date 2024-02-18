package com.zebrunner.carina.demo.enums;

public enum ProductDetail {
    PRODUCT_NAME1("Tank"),
    PRODUCT_NAME2("Juno Jacket"),
    COLOR_OPTION1("black"),
    COLOR_OPTION2("blue"),
    COLOR_OPTION3("gray"),
    COLOR_OPTION4("red"),
    PRICE_FROM("2"),
    PRICE_TO("12"),
    INVALID("");

    private final String value;

    ProductDetail(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
