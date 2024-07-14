package com.exprivia.negozio.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exprivia.negozio.exception.ClienteNonTrovato;
import com.exprivia.negozio.model.Cliente;
import com.exprivia.negozio.repository.ClienteRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clienti")
	public List<Cliente> getAllClienti(){
		return clienteRepository.findAll();
	}
		
	
	@PostMapping("/clienti")
	public Cliente creaCliente(@RequestBody Cliente cliente) {
	return clienteRepository.save(cliente);
	}
	
	
	@GetMapping("/clienti/{idCli}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long idCli) {
		Cliente cliente = clienteRepository.findById(idCli)
				.orElseThrow(() -> new ClienteNonTrovato("Nessun cliente trovato con id:" + idCli));
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping("/clienti/{idCli}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long idCli, @RequestBody Cliente dettagliCliente){
		Cliente cliente = clienteRepository.findById(idCli)
				.orElseThrow(() -> new ClienteNonTrovato("Nessun cliente trovato con id:" + idCli));
		cliente.setNomeCli(dettagliCliente.getNomeCli());
		cliente.setCognomeCli(dettagliCliente.getCognomeCli());
		cliente.setEmailCli(dettagliCliente.getEmailCli());
		cliente.setIndirizzoCli(dettagliCliente.getIndirizzoCli());
	    cliente.setDataUltimaModifica(LocalDateTime.now());
		Cliente updatedCliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(updatedCliente);
	}


	@DeleteMapping("/clienti/{idCli}")
	public ResponseEntity<Map<String, Boolean>> eliminaCliente(@PathVariable Long idCli){
		Cliente cliente = clienteRepository.findById(idCli)
				.orElseThrow(() -> new ClienteNonTrovato("Nessun cliente trovato per l'id:" + idCli));
		clienteRepository.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("eliminato", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/clienti/check/{codiceFiscaleCli}")
	public ResponseEntity<Boolean> controlloCf(@PathVariable String codiceFiscaleCli) {
	    boolean esiste = clienteRepository.existsByCodiceFiscaleCli(codiceFiscaleCli);
	    return ResponseEntity.ok(esiste);
	}
	
}

