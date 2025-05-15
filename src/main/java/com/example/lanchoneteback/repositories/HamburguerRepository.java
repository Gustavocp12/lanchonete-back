package com.example.lanchoneteback.repositories;

import com.example.lanchoneteback.domains.Hamburguer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HamburguerRepository extends JpaRepository<Hamburguer, Integer> {
}
