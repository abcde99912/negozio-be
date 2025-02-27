package com.exprivia.negozio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exprivia.negozio.model.ProfiloCli;
import com.exprivia.negozio.repository.ProfiloCliRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProfiloCliController {
	
	@Autowired
	private ProfiloCliRepository profiloCliRepository;

	@GetMapping("/cat")
	public List<ProfiloCli> getAllProfili(){
		return profiloCliRepository.findAll();
}


}
