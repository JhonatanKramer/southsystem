package com.southsystem.southsystem.service;

import java.util.Optional;

import com.southsystem.southsystem.model.entity.Config;

public interface ConfigService {

	Optional<Config> obterPorId(Long idconfig);

	Config atualizar(Config config);

}
