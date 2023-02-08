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
public class DadosAutenticacaoDTO {

	@NotBlank
	private String login;
	@NotBlank
	private String senha;
	
}
