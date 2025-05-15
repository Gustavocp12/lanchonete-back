package com.example.lanchoneteback.dtos;

import com.example.lanchoneteback.enums.ItemFlag;
import com.example.lanchoneteback.enums.ItemType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    @NotNull
    private ItemType type;

    @NotBlank
    private String description;

    @NotNull
    private Double price;

    @NotNull
    private ItemFlag flag;
}
