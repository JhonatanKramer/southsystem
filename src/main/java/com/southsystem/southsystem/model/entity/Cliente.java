package com.southsystem.southsystem.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Long idcliente;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "numero_documento")
	private int numeroDocumento;
	
	@Column(name = "score")
	private int score;

}
