package com.exprivia.negozio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "utenti")
public class Utente {
    @Id
    private Long id;
    private String username;
    private String password;
}
