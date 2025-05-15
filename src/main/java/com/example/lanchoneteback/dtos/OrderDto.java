package com.example.lanchoneteback.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Date date;
    private String description;
    private String name;
    private String address;
    private String phone;
    private List<Integer> itemIds;
    private List<Integer> additionalItemIds;
    private List<Integer> hamburguerIds;
    private List<String> observations;
    private Double total;

}
