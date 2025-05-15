package com.example.lanchoneteback.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hamburguer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hamburguer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private Double price;

    @ManyToMany
    @JoinTable(
            name = "hamburguer_items",
            joinColumns = @JoinColumn(name = "hamburguer_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;
}
