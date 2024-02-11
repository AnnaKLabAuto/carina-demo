package com.zebrunner.carina.demo.enums;

public enum ProductDetail {
    PRODUCT_NAME1("Tank"),
    PRODUCT_NAME2("Juno Jacket"),
    SIZE("S"),
    COLOR("Green"),
    QUANTITY("1"),
    PRICE_FROM("2"),
    PRICE_TO("12"),
    INVALID(" ");

    private final String value;

    ProductDetail(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
