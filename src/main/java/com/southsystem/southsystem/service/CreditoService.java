package com.southsystem.southsystem.service;

import java.util.List;
import java.util.Optional;

import com.southsystem.southsystem.model.entity.Credito;

public interface CreditoService {

	List<Credito> buscar(Credito credito);

	Credito obterPorId(Long idCredito);
	
	Credito atualizar(Credito credito);

}
