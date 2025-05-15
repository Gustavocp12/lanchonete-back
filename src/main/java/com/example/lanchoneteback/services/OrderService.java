package com.example.lanchoneteback.services;

import com.example.lanchoneteback.domains.Hamburguer;
import com.example.lanchoneteback.domains.Item;
import com.example.lanchoneteback.domains.Order;
import com.example.lanchoneteback.dtos.OrderDto;
import com.example.lanchoneteback.repositories.HamburguerRepository;
import com.example.lanchoneteback.repositories.ItemRepository;
import com.example.lanchoneteback.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final HamburguerRepository hamburguerRepository;
    private final ItemRepository itemRepository;

    public Order registerOrder(OrderDto dto) {
        Order order = new Order();

        Double itemTotal = itemRepository.findAllById(dto.getItemIds()).stream()
                .mapToDouble(Item::getPrice)
                .sum();

        Double additionalItemTotal = itemRepository.findAllById(dto.getAdditionalItemIds()).stream()
                .mapToDouble(Item::getPrice)
                .sum();

        Double hamburguerTotal = hamburguerRepository.findAllById(dto.getHamburguerIds()).stream()
                .mapToDouble(Hamburguer::getPrice)
                .sum();

        order.setTotal(itemTotal + additionalItemTotal + hamburguerTotal);

        order.setDate(dto.getDate());
        order.setDescription(dto.getDescription());
        order.setName(dto.getName());
        order.setAddress(dto.getAddress());
        order.setPhone(dto.getPhone());

        order.setItems(itemRepository.findAllById(dto.getItemIds()));
        order.setAdditionalItems(itemRepository.findAllById(dto.getAdditionalItemIds()));
        order.setHamburguers(hamburguerRepository.findAllById(dto.getHamburguerIds()));
        order.setObservations(dto.getObservations());

        return repository.save(order);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }
}
