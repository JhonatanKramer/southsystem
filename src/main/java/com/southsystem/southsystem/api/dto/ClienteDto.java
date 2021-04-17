package com.southsystem.southsystem.api.dto;

import javax.persistence.Column;

import com.southsystem.southsystem.model.enums.ClienteTipo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
	
	private String nome;
	private String numeroDocumento;

}
