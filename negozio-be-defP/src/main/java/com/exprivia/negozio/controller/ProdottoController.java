package com.exprivia.negozio.controller;

import com.exprivia.negozio.model.Prodotto;
import com.exprivia.negozio.repository.ProdottoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProdottoController {


	@Autowired
	private ProdottoRepository prodottoRepository;

	@GetMapping("/inventario")
	public List<Prodotto> getAllProdotti(){
		return prodottoRepository.findAll();
	}

}