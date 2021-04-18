package com.southsystem.southsystem.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.southsystem.southsystem.api.dto.ConfigDto;
import com.southsystem.southsystem.api.dto.CreditoDto;
import com.southsystem.southsystem.exception.Exceptions;
import com.southsystem.southsystem.model.entity.Config;
import com.southsystem.southsystem.model.entity.Credito;
import com.southsystem.southsystem.service.ConfigService;
import com.southsystem.southsystem.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(value = "Configurações")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/config")
@RequiredArgsConstructor
public class ConfigController {
	
	private final ConfigService configService ;

	@ApiOperation(value = "busca agencia cadastrada")
	@GetMapping("/buscar")
	public ResponseEntity buscar() {
		List<Config> config = configService.buscar();
		return ResponseEntity.ok(config);
	}	
	
	@ApiOperation(value = "atualiza configuracao de agencia")
	@PutMapping("atualizar/{idConfig}")
	public ResponseEntity atualizar(@PathVariable("idConfig") Long idConfig, @RequestBody ConfigDto dto) {		
		try {			
			Config config = configService.obterPorId(idConfig);
			config = Config.builder().agenciaPadrao(dto.getAgencia()).build();
			config.setIdconfig(idConfig);
			configService.atualizar(config);
			return ResponseEntity.ok(config);
		} catch (Exceptions e) {			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}

