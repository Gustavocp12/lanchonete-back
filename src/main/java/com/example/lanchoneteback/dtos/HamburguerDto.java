package com.example.lanchoneteback.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HamburguerDto {

    private String description;
    private Double price;
    private List<Integer> itemIds;
    
}
