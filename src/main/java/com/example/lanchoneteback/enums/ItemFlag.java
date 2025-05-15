package com.example.lanchoneteback.enums;

import lombok.Getter;

@Getter
public enum ItemFlag {
    NOTHING(0),
    SUGAR(1),
    ADDITIONAL(2);

    private final int value;

    ItemFlag(int value) {
        this.value = value;
    }

    public static ItemFlag fromValue(int value) {
        for (ItemFlag flag : ItemFlag.values()) {
            if (flag.getValue() == value) {
                return flag;
            }
        }
        throw new IllegalArgumentException("Invalid ItemFlag value: " + value);
    }
}
