package com.southsystem.southsystem.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.southsystem.southsystem.api.dto.ClienteDtoCadastro;
import com.southsystem.southsystem.exception.Exceptions;
import com.southsystem.southsystem.model.entity.Cliente;
import com.southsystem.southsystem.service.ClienteService;
import com.southsystem.southsystem.service.ContaService;
import com.southsystem.southsystem.util.Util;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteService clienteService;
	private final ContaService contaService;

	@PostMapping("/cadastrar")	
	public ResponseEntity cadastrar(@RequestBody ClienteDtoCadastro dto) {

		Cliente cliente = Cliente.builder().nome(dto.getNome()).numeroDocumento(dto.getNumeroDocumento()).build();
		
		try {
			Cliente clienteSalvo = clienteService.cadastrar(cliente);
			return new ResponseEntity(clienteSalvo, HttpStatus.CREATED);
		} catch (Exceptions e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	@GetMapping
	public ResponseEntity buscar(@RequestParam(value = "nome", required = false) String nome) {
		Cliente clienteFilto = new Cliente();
		clienteFilto.setNome(nome);

		List<Cliente> clientes = clienteService.buscar(clienteFilto);
		return ResponseEntity.ok(clientes);

	}

}
