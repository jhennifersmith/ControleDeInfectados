package com.api.controleinfectados.controllers;

import javax.validation.Valid;

import com.api.controleinfectados.dtos.DadosAutenticacaoDTO;
import com.api.controleinfectados.dtos.DadosTokenJwtDTO;
import com.api.controleinfectados.models.UsuarioModel;
import com.api.controleinfectados.services.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados) {
		var authenticationToken = new UsernamePasswordAuthenticationToken(dados.getLogin(), dados.getSenha());
		Authentication authentication = manager.authenticate(authenticationToken);
		
		var tokenJWT = tokenService.gerarToken((UsuarioModel) authentication.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJwtDTO(tokenJWT));
	}
	
}
