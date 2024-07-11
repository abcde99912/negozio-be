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
@Table(name = "profiloClienti")
@Data
public class ProfiloCli {
	
	@Id
	@Column(name ="idProfilo")
	private Integer idPrf;
	private String descPrf;

	@JsonIgnore   
	@OneToMany(
			mappedBy = "profiloCli", 
			fetch = FetchType.EAGER)
    private Set<Cliente> clienti;	
	}
	
	


