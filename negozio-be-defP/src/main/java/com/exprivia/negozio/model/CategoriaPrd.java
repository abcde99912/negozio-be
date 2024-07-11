package com.exprivia.negozio.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "categoriaProdotto")
@Data
public class CategoriaPrd 
{
	@Id
	@Column(name = "idCatPrd")
	private int idCatPrd;
	
	@Column(name = "descCatProd")
	private String descPrd;
	
	   
	@JsonIgnore   
	@OneToMany(
			mappedBy = "categoriaPrd",  fetch = FetchType.EAGER)
	private Set<Prodotto> prodotto;	
	}
	


