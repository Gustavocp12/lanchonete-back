package com.example.lanchoneteback.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;
    private String description;
    private String name;
    private String address;
    private String phone;

    @ManyToMany
    @JoinTable(
            name = "orders_items",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;

    @ManyToMany
    @JoinTable(
            name = "orders_additional_items",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "additional_item_id")
    )
    private List<Item> additionalItems;

    @ManyToMany
    @JoinTable(
            name = "orders_hamburguers",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "hamburguer_id")
    )
    private List<Hamburguer> hamburguers;

    @ElementCollection
    private List<String> observations;

    private Double total;
}
