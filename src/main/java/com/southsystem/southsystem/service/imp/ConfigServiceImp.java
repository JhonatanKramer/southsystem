package com.southsystem.southsystem.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.southsystem.southsystem.model.entity.Config;
import com.southsystem.southsystem.model.repository.ConfigRepository;
import com.southsystem.southsystem.service.ConfigService;

@Service
public class ConfigServiceImp implements ConfigService {

	private ConfigRepository configRepository;

	@Autowired
	public ConfigServiceImp(ConfigRepository configRepository) {
		super();
		this.configRepository = configRepository;
	}

	@Override
	public Optional<Config> obterPorId(Long idconfig) {
		return null;
	}

	@Override
	public Config atualizar(Config config) {
		// TODO Auto-generated method stub
		return null;
	}

}
