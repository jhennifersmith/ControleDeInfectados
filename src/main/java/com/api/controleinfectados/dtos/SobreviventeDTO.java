package com.api.controleinfectados.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.controleinfectados.enums.EstadoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SobreviventeDTO {

	@NotBlank
	private String nome;
	
	@NotNull
	private Long idade;
	
	@NotBlank
	private String filiacao;
	
	@NotNull
	private EstadoEnum estado;
	
}
