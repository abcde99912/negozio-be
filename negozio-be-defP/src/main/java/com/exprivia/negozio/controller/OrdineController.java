package com.exprivia.negozio.controller;

import com.exprivia.negozio.model.Ordini;
import com.exprivia.negozio.repository.OrdiniRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/")

public class OrdineController {
	
    @Autowired
    private OrdiniRepository ordiniRepository;

	@GetMapping("/ordini")
	public List<Ordini> getAllOrdini(){
		return ordiniRepository.findAll();
	}
	
}