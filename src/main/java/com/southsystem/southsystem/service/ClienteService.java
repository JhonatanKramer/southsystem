package com.southsystem.southsystem.service;

import java.util.List;
import java.util.Optional;

import com.southsystem.southsystem.model.entity.Cliente;
import com.southsystem.southsystem.model.enums.ClienteTipo;

public interface ClienteService {

	Cliente cadastrar(Cliente cliente);

	List<Cliente> buscar();

	Optional<Cliente> obterPorId(Long idcliente);

	ClienteTipo identificaTipo(String numeroDocumento);

	boolean ClienteNaoCadastrado(String numeroDocumento);

	Cliente buscaPorDocumento(String numeroDocumento);

}
