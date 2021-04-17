package com.southsystem.southsystem.model.entity;

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
@Table(name = "conta")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conta {
	
	@Id
	@Column(name = "idcliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idconta;
	
	@Column(name = "agencia")
	private int agencia;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "limite_cheque")
	private double limiteCheque;
	
	@Column(name = "limite_cartao")
	private double limiteCartao;

}
