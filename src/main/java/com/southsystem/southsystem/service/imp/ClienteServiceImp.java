package com.southsystem.southsystem.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.southsystem.exception.Exceptions;
import com.southsystem.southsystem.model.entity.Cliente;
import com.southsystem.southsystem.model.enums.ClienteTipo;
import com.southsystem.southsystem.model.repository.ClienteRepository;
import com.southsystem.southsystem.service.ClienteService;
import com.southsystem.southsystem.util.Util;

@Service
public class ClienteServiceImp implements ClienteService {

	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteServiceImp(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {		
		cliente.setNumeroDocumento(Util.retiraCaracteresEspeciais(cliente.getNumeroDocumento()));
		cliente.setTipo(identificaTipo(cliente.getNumeroDocumento()));

		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscar() {
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> obterPorId(Long idcliente) {
		return clienteRepository.findById(idcliente);
	}

	@Override
	public ClienteTipo identificaTipo(String numeroDocumento) {

		if (numeroDocumento.length() == 14) {
			if (Util.isCNPJ(numeroDocumento)) {
				if (ClienteNaoCadastrado(numeroDocumento)) {
					return ClienteTipo.PJ;
				}
			} else {
				throw new Exceptions("CNPJ invalido, favor informar um CNPJ valido ");
			}

		} else if (numeroDocumento.length() == 11) {
			if (Util.isCPF(numeroDocumento)) {
				if (ClienteNaoCadastrado(numeroDocumento)) {
					return ClienteTipo.PF;
				}
			}
		}

		throw new Exceptions("Numero de caracteres não confere com CPF ou CNPJ ");

	}

	@Override
	public boolean ClienteNaoCadastrado(String numeroDocumento) {
		Optional<Cliente> cliente = clienteRepository.findByNumeroDocumento(numeroDocumento);

		if (cliente.isPresent()) {
			throw new Exceptions("Cliente já esta cadastrado na base de dados");
		}
		return true;
	}

	@Override
	public Cliente buscaPorDocumento(String numeroDocumento) {
		Optional<Cliente> cliente = clienteRepository.findByNumeroDocumento(numeroDocumento);
		Cliente clienteb = cliente.get();
		return clienteb;
	}

}
