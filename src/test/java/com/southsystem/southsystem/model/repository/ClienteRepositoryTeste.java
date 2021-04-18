package com.southsystem.southsystem.model.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.southsystem.southsystem.model.entity.Cliente;
import com.southsystem.southsystem.model.enums.ClienteTipo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ClienteRepositoryTeste {

	@Autowired
	ClienteRepository clienteRepository;

	public void deveBuscarNumeroDocumento() {
		Cliente cliente = Cliente.builder().nome("nome").numeroDocumento("12345678901").tipo(ClienteTipo.PF).build();
		clienteRepository.save(cliente);
		Optional<Cliente> result = clienteRepository.findByNumeroDocumento(cliente.getNumeroDocumento());
		Assertions.assertThat(result.isPresent()).isTrue();
	}
}
