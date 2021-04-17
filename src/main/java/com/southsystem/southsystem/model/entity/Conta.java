package com.southsystem.southsystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.southsystem.southsystem.model.enums.ContaTipo;

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
	@Enumerated(value = EnumType.STRING)
	private ContaTipo tipo;
	
	
	@OneToOne
	@JoinColumn(name = "score")
	private Credito score;
	
	@OneToOne
	@JoinColumn(name = "idcliente")
	private Cliente cliente; 	

}
