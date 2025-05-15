package com.example.lanchoneteback.domains;

import com.example.lanchoneteback.enums.ItemFlag;
import com.example.lanchoneteback.enums.ItemType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    private String description;
    private Double price;

    @Enumerated(EnumType.STRING)
    private ItemFlag flag;

    public boolean isNothing(){
        return this.flag == ItemFlag.NOTHING;
    }

    public boolean isSugar(){
        return this.flag == ItemFlag.SUGAR;
    }

    public boolean isAdditional(){
        return this.flag == ItemFlag.ADDITIONAL;
    }
}
