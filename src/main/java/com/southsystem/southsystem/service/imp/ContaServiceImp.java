package com.southsystem.southsystem.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.southsystem.model.entity.Cliente;
import com.southsystem.southsystem.model.entity.Conta;
import com.southsystem.southsystem.model.entity.Credito;
import com.southsystem.southsystem.model.enums.ContaTipo;
import com.southsystem.southsystem.model.repository.ContaRepository;
import com.southsystem.southsystem.service.ContaService;
import com.southsystem.southsystem.service.CreditoService;

@Service
public class ContaServiceImp implements ContaService {

	private ContaRepository contaRepository;

	@Autowired
	public ContaServiceImp(ContaRepository contaRepository) {
		super();
		this.contaRepository = contaRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Conta> buscar() {
		return contaRepository.findAll();
	}


}
