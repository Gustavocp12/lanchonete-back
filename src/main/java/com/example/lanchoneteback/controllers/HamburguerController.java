package com.example.lanchoneteback.controllers;

import com.example.lanchoneteback.domains.Hamburguer;
import com.example.lanchoneteback.dtos.HamburguerDto;
import com.example.lanchoneteback.services.HamburguerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hamburger")
@AllArgsConstructor
public class HamburguerController {

    private final HamburguerService hamburguerService;

    @PostMapping
    public ResponseEntity<Hamburguer> registerHamburguer(@RequestBody @Valid HamburguerDto dto) {
        Hamburguer newHamburguer = hamburguerService.registerHamburguer(dto);
        return ResponseEntity.ok(newHamburguer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HamburguerDto> findById(@PathVariable int id) {
        HamburguerDto dto = hamburguerService.findById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Hamburguer>> findAll() {
        List<Hamburguer> hamburgers = hamburguerService.findAll();
        return ResponseEntity.ok(hamburgers);
    }
}
