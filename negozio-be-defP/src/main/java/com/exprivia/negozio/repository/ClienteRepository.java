package com.exprivia.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exprivia.negozio.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
	
	boolean existsByCodiceFiscaleCli(String codiceFiscaleCli);
    

}