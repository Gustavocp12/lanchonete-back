package com.example.lanchoneteback.controllers;

import com.example.lanchoneteback.domains.Item;
import com.example.lanchoneteback.dtos.ItemDto;
import com.example.lanchoneteback.services.ItemService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> registerItem(@RequestBody @Valid ItemDto items) {

        Item newItem = itemService.registerItem(items);
        return ResponseEntity.ok(newItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findById(@PathVariable int id) {
        Item newItem = itemService.findById(id);
        return ResponseEntity.ok(newItem);
    }

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        List<Item> items = itemService.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<Item>> findByDescription(@PathVariable String description) {
        List<Item> items = itemService.findByDescription(description);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Item>> findByType(@PathVariable String type) {
        List<Item> items = itemService.findByType(type);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/flagAndType/{flag}/{type}")
    public ResponseEntity<List<Item>> findByFlagAndType(@PathVariable String flag, @PathVariable String type) {
        List<Item> items = itemService.findByFlagAndType(flag, type);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/descriptionOrId/{descriptionOrId}")
    public ResponseEntity<List<Item>> findByDescriptionOrId(@PathVariable String descriptionOrId) {
        List<Item> items = itemService.findByDescriptionOrId(descriptionOrId);
        return ResponseEntity.ok(items);
    }
}