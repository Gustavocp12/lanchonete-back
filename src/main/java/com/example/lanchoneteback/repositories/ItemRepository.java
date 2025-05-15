package com.example.lanchoneteback.repositories;

import com.example.lanchoneteback.domains.Item;
import com.example.lanchoneteback.enums.ItemFlag;
import com.example.lanchoneteback.enums.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByTypeAndFlag(ItemType type, ItemFlag flag);

}
