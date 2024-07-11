package com.exprivia.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exprivia.negozio.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Utente findByUsernameAndPassword(String username, String password);
}