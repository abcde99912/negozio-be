package com.exprivia.negozio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClienteNonTrovato extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public ClienteNonTrovato(String message) {
		super(message);
	}
}
