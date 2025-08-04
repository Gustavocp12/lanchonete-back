package com.example.lanchoneteback.services;

import com.example.lanchoneteback.domains.Item;
import com.example.lanchoneteback.dtos.ItemDto;
import com.example.lanchoneteback.enums.ItemFlag;
import com.example.lanchoneteback.enums.ItemType;
import com.example.lanchoneteback.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public Item registerItem(ItemDto dto) {
        Item item = new Item();
        item.setType(dto.getType());
        item.setDescription(dto.getDescription());
        item.setPrice(dto.getPrice());
        item.setFlag(dto.getFlag());
        return repository.save(item);
    }

    public Item findById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public List<Item> findAll() {
        return repository.findAll();
    }

    public List<Item> findByDescription(String description) {
        return repository.findAll().stream()
                .filter(item -> item.getDescription().toLowerCase().contains(description.toLowerCase()))
                .toList();
    }

    public List<Item> findByType(String typeStr) {
        int typeValue = Integer.parseInt(typeStr);
        ItemType itemType = ItemType.fromValue(typeValue);

        return repository.findAll().stream()
                .filter(item -> item.getType() == itemType)
                .toList();
    }

    public List<Item> findByFlagAndType(String flag, String typeStr) {
        return repository.findByTypeAndFlag(
                ItemType.fromValue(Integer.parseInt(typeStr)),
                ItemFlag.fromValue(Integer.parseInt(flag))
        );
    }

    public List<Item> findByDescriptionOrId(String descriptionOrId) {
        return repository.findAll().stream()
                .filter(item -> item.getDescription().toLowerCase().contains(descriptionOrId.toLowerCase()) ||
                        String.valueOf(item.getId()).equals(descriptionOrId))
                .toList();
    }

    public List<Item> deleteById(int id) {
        Item item = findById(id);
        repository.delete(item);

        return repository.findAll();
    }

    public Item updateItem(int id, ItemDto dto) {
        Item item = findById(id);
        item.setType(dto.getType());
        item.setDescription(dto.getDescription());
        item.setPrice(dto.getPrice());
        item.setFlag(dto.getFlag());
        repository.save(item);

        return item;
    }
}
