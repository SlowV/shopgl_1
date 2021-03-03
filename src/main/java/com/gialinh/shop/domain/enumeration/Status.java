package com.gialinh.shop.domain.enumeration;

/**
 * @author SlowV
 * @createdAt 3/2/21_10:38 AM
 * @updatedAt 3/2/21_10:38 AM
 * @description
 */
public enum Status {
    ACTIVED("Hoạt động"),
    BLOCKED("Đã khoá"),
    DELETED("Đã xoá");

    private final String value;


    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}