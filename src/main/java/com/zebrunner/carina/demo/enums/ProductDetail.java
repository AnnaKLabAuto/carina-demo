package com.zebrunner.carina.demo.enums;

public enum ProductDetail {
    PRODUCT_NAME1("Tank"),
    PRODUCT_NAME2("Tee"),
    SIZE("S"),

    COLOR("Orange");

    private final String productDetail;

    ProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getStatus() {
        return productDetail;
    }
}
