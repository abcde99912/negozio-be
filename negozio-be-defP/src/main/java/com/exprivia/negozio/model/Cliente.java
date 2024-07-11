package com.exprivia.negozio.model;

import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Table(name = "cliente")
@Data

public class Cliente{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCli;

	@Column(name = "nomeCliente")
	private String nomeCli;

	@Column(name = "cognomeCliente")
	private String cognomeCli;

	@Column(name = "emailCliente")
	private String emailCli;
	
	@Column(name = "indirizzoCliente")
	private String indirizzoCli;
	
	@Column(name = "codiceFisclale")
	private String codiceFiscaleCli;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataCreCli")
	private Date dataCreCli;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="profiloCliente"
	)
	private ProfiloCli profiloCli;
	
	@JsonIgnore 
    @OneToMany(mappedBy = "idCliente")
    private Set<Ordini> ordini;

	}	





