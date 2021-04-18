package com.southsystem.southsystem.service.imp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.southsystem.exception.Exceptions;
import com.southsystem.southsystem.model.entity.Config;
import com.southsystem.southsystem.model.repository.ConfigRepository;
import com.southsystem.southsystem.service.ConfigService;
import com.southsystem.southsystem.util.Util;

@Service
public class ConfigServiceImp implements ConfigService {

	private ConfigRepository configRepository;

	@Autowired
	public ConfigServiceImp(ConfigRepository configRepository) {
		super();
		this.configRepository = configRepository;
	}

	@Override
	@Transactional
	public Config atualizar(Config config) {
		Objects.requireNonNull(config.getIdconfig());
		return configRepository.save(config);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Config> buscar() {
		return configRepository.findAll();
	}
	
	@Override
	public Config obterPorId(Long idConfig) {
	
		Optional<Config> ConfigOption = configRepository.findById(idConfig);
		if (!ConfigOption.isPresent()) {
			throw new Exceptions("Erro Id informado esta invalido ");
		}
		Config config = ConfigOption.get();
		return config;
	}

}
