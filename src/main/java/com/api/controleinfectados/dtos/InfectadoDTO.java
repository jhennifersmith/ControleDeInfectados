package com.api.controleinfectados.dtos;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InfectadoDTO {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String aparencia;
	
	@NotBlank
	private String comportamento;
}
