package com.example.lanchoneteback.services;

import com.example.lanchoneteback.domains.Hamburguer;
import com.example.lanchoneteback.domains.Item;
import com.example.lanchoneteback.dtos.HamburguerDto;
import com.example.lanchoneteback.repositories.HamburguerRepository;
import com.example.lanchoneteback.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HamburguerService {

    private final HamburguerRepository repository;
    private final ItemRepository itemRepository;

    public Hamburguer registerHamburguer(HamburguerDto dto) {

        Hamburguer hamburguer = new Hamburguer();
        hamburguer.setDescription(dto.getDescription());
        hamburguer.setPrice(dto.getPrice());
        hamburguer.setItems(itemRepository.findAllById(dto.getItemIds()));

        return repository.save(hamburguer);
    }

    public HamburguerDto findById(int id) {
        HamburguerDto dto = new HamburguerDto();

        Hamburguer hamburguer = repository.findById(id).orElse(null);
        if (hamburguer != null) {
            dto.setDescription(hamburguer.getDescription());
            dto.setPrice(hamburguer.getPrice());
            dto.setItemIds(hamburguer.getItems().stream().map(Item::getId).toList());
        }
        return dto;
    }

    public List<Hamburguer> findAll() {
        return repository.findAll();
    }
}
