package com.southsystem.southsystem.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.southsystem.southsystem.model.entity.Cliente;
import com.southsystem.southsystem.model.enums.ClienteTipo;
import com.southsystem.southsystem.model.repository.ClienteRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ClienteServiceTest {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteService ClienteServiceTest;

	@Test
	public void ClienteNaoCadastrado() {
		clienteRepository.deleteAll();
		ClienteServiceTest.ClienteNaoCadastrado("12345678908");

	}

	@Test
	public void buscaPorDocumento() {
		Cliente cliente = Cliente.builder().nome("nome").numeroDocumento("12345678901").tipo(ClienteTipo.PF).build();
		clienteRepository.save(cliente);
		Optional<Cliente> result = clienteRepository.findByNumeroDocumento(cliente.getNumeroDocumento());
		Assertions.assertThat(result.isPresent()).isTrue();

	}
	
	@Test
	public void obterPorId() {
		Cliente cliente = Cliente.builder().nome("nome").numeroDocumento("12345678905").tipo(ClienteTipo.PF).build();
		Cliente clbd = clienteRepository.save(cliente);
		Optional<Cliente> result = clienteRepository.findById(clbd.getIdCliente());
		Assertions.assertThat(result.isPresent()).isTrue();
	}

}
