package com.southsystem.southsystem.service.imp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.southsystem.exception.Exceptions;
import com.southsystem.southsystem.model.entity.Credito;
import com.southsystem.southsystem.model.repository.CreditoRepository;
import com.southsystem.southsystem.service.CreditoService;

@Service
public class CreditoServiceImp implements CreditoService {

	private CreditoRepository creditoRepository;

	@Autowired
	public CreditoServiceImp(CreditoRepository creditoRepository) {
		super();
		this.creditoRepository = creditoRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Credito> buscar() {
		return creditoRepository.findAll();
	}

	@Override
	public Credito obterPorId(Long idCredito) {
		Optional<Credito> creditoOption = creditoRepository.findById(idCredito);
		if (! creditoOption.isPresent()) {
			throw new Exceptions("Score não encontrado para alteração ");
		}
		Credito credito = creditoOption.get();
		return credito;
	}

	@Override
	@Transactional
	public Credito atualizar(Credito credito) {
		Objects.requireNonNull(credito.getScore());
		return creditoRepository.save(credito);
	}

}
