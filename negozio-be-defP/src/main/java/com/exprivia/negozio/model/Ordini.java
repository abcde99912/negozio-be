package com.exprivia.negozio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "ordini")
@Data
public class Ordini {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrdine")
    private Long idOrdine;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCLiente", nullable = false)
    private Cliente idCliente;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProdotto", nullable = false)
    private Prodotto idProdotto;
    
    @Column(name = "quantita")
    private Integer quantita;
    
    @Column(name = "dataOrdine")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOrdine;
    
}