package com.exprivia.negozio.model;

import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "prodotto")
@Data

public class Prodotto
{

	@Id
	@Column
	(name = "idPrd")
	private Long idPrd;
	
	@Column(name = "descrizioneProdotto")
	private String descPrd;	
	
	@Column(name = "quantitaProdotto")
	private Integer qtaPrd;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataCreazione")
	private Date dataCPrd;

	@ManyToOne
	@JoinColumn(name="categoriaProdotto")
	private CategoriaPrd categoriaPrd;


	@JsonIgnore
	@OneToMany(mappedBy = "idProdotto")
    private Set<Ordini> ordini;
     
}


