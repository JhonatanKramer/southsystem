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

import com.southsystem.southsystem.api.dto.ClienteDto;
import com.southsystem.southsystem.exception.Exceptions;
import com.southsystem.southsystem.model.entity.Cliente;
import com.southsystem.southsystem.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(value = "Cliente")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteService clienteService;
	
	@ApiOperation(value = "Cadastra cliente no banco de dados")
	@PostMapping("/cadastrar")
	public ResponseEntity cadastrar(@RequestBody ClienteDto dto) {

		Cliente cliente = Cliente.builder().nome(dto.getNome()).numeroDocumento(dto.getNumeroDocumento()).build();

		try {
			Cliente clienteSalvo = clienteService.cadastrar(cliente);
			return new ResponseEntity(clienteSalvo, HttpStatus.CREATED);
		} catch (Exceptions e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	@ApiOperation(value = "busca todos cliente no banco de dados")
	@GetMapping("/buscar")
	public ResponseEntity buscar() {
		List<Cliente> clientes = clienteService.buscar();
		return ResponseEntity.ok(clientes);
	}

}
