package com.southsystem.southsystem.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.southsystem.southsystem.model.entity.Conta;
import com.southsystem.southsystem.service.ContaService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/conta")
@RequiredArgsConstructor
public class ContaController {

	
	private final ContaService contaService;
	
	@GetMapping("/buscar")
	public ResponseEntity buscar() {
		List<Conta> conta = contaService.buscar();
		return ResponseEntity.ok(conta);
	}
}
