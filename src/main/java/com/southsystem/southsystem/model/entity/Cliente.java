package com.southsystem.southsystem.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.southsystem.southsystem.model.enums.ClienteTipo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	@Id
	@Column(name = "idcliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "tipo")
	@Enumerated(value = EnumType.STRING)
	private ClienteTipo tipo;
	
	@Column(name = "numero_documento")
	private String numeroDocumento;
	
}
