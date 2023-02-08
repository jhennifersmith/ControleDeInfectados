package com.api.controleinfectados.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.controleinfectados.dtos.InfectadoDTO;
import com.api.controleinfectados.models.InfectadoModel;
import com.api.controleinfectados.services.InfectadoService;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/infectado")
public class InfectadoController {

	@Autowired
	private InfectadoService infectadoService;
	
	@GetMapping
	public ResponseEntity<List<InfectadoModel>> getAllInfectados(){
		return ResponseEntity.status(HttpStatus.OK).body(infectadoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getInfectado(@PathVariable(value = "id") Long id){
		Optional<InfectadoModel> infectadoModelOptional = infectadoService.getById(id);
		if (!infectadoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Infectado não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(infectadoModelOptional.get());
	}
	
	@PostMapping
	public ResponseEntity<Object>saveInfectado(@RequestBody @Valid InfectadoDTO infectadoDTO, UriComponentsBuilder uriBuilder){
		var infectadoModel = new InfectadoModel();
		BeanUtils.copyProperties(infectadoDTO, infectadoModel);
		infectadoService.save(infectadoModel);
		URI uri = uriBuilder.path("infectado/{id}").buildAndExpand(infectadoModel.getId()).toUri();
		return ResponseEntity.created(uri).body(infectadoModel);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateInfectado(@PathVariable(value="id") Long id,
												@RequestBody @Valid InfectadoDTO infectadoDTO){
		Optional<InfectadoModel> infectadoModelOptional = infectadoService.getById(id);
		if (!infectadoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Infectado não encontrado");
		}
		var infectadoModel = new InfectadoModel();
		BeanUtils.copyProperties(infectadoDTO, infectadoModel);
		infectadoModel.setId(infectadoModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(infectadoService.save(infectadoModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteInfectado(@PathVariable(value = "id") Long id){
		Optional<InfectadoModel> infectadoModelOptional = infectadoService.getById(id);
		if(!infectadoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Infectado não encontrado");
		}
		infectadoService.delete(infectadoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Infectado deletado com sucesso!");
	}
	
}
