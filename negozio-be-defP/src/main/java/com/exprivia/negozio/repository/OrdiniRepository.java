package com.exprivia.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exprivia.negozio.model.Ordini;

public interface OrdiniRepository extends JpaRepository<Ordini, Long> {
}