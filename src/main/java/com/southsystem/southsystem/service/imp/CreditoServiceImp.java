package com.southsystem.southsystem.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Credito> buscar(Credito credito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credito obterPorId(Long idCredito) {
		Optional<Credito> creditoOption = creditoRepository.findById(idCredito);
		Credito credito = creditoOption.get();
		return credito;
	}

	@Override
	public Credito atualizar(Credito credito) {
		// TODO Auto-generated method stub
		return null;
	}

}
