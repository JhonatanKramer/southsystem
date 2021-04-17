package com.southsystem.southsystem.service;

import java.util.List;
import java.util.Optional;

import com.southsystem.southsystem.model.entity.Config;
import com.southsystem.southsystem.model.entity.Credito;

public interface ConfigService {

	List<Config> buscar();

	Config atualizar(Config config);
	
	Config obterPorId(Long idConfig);

}
