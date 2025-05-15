package com.example.lanchoneteback.enums;

import lombok.Getter;

@Getter
public enum ItemType {
    DRINK(0),
    INGREDIENTS(1);

    private final int value;

    ItemType(int value) {
        this.value = value;
    }

    public static ItemType fromValue(int value) {
        for (ItemType type : ItemType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid ItemType value: " + value);
    }
}
