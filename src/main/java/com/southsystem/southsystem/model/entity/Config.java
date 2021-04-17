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
@Table(name = "config")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Config {
	
	@Id
	@Column(name = "idconfig")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idconfig;
	
	@Column(name = "agencia_padrao")
	private int agenciaPadrao;

}
