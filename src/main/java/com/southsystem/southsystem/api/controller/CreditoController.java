package com.southsystem.southsystem.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.southsystem.southsystem.api.dto.CreditoDto;
import com.southsystem.southsystem.exception.Exceptions;
import com.southsystem.southsystem.model.entity.Credito;
import com.southsystem.southsystem.service.CreditoService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/credito")
@RequiredArgsConstructor
public class CreditoController {

	private final CreditoService creditoService;

	@GetMapping("/buscar")
	public ResponseEntity buscar() {
		List<Credito> credito = creditoService.buscar();
		return ResponseEntity.ok(credito);
	}

	@PutMapping("atualizar/{idCredito}")
	public ResponseEntity atualizar(@PathVariable("idCredito") Long idCredito, @RequestBody CreditoDto dto) {		
		try {			
			Credito credito = creditoService.obterPorId(idCredito);
			credito = Credito.builder().limiteCartao(dto.getLimiteCartao()).limiteCheque(dto.getLimiteCheque()).build();
			credito.setScore(idCredito);
			creditoService.atualizar(credito);
			return ResponseEntity.ok(credito);
		} catch (Exceptions e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}
