package com.exprivia.negozio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exprivia.negozio.exception.ErroreAutenticazione;
import com.exprivia.negozio.model.Utente;
import com.exprivia.negozio.repository.UtenteRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class LoginController {

	@Autowired
	private UtenteRepository utenteRepository;

    @PostMapping("/login")
    public ResponseEntity<ErroreAutenticazione> login(@RequestBody Utente login) {
        Utente user = utenteRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
        if (user != null) {
            return ResponseEntity.ok(new ErroreAutenticazione(true, "Login riuscito"));
        } else {
            return ResponseEntity.badRequest().body(new ErroreAutenticazione(false, "Credenziali non valide"));
        }
    }
}
