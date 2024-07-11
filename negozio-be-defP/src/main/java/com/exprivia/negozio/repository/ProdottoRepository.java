package com.exprivia.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exprivia.negozio.model.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

}
