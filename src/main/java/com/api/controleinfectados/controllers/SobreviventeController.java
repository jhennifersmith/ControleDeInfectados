package com.api.controleinfectados.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.controleinfectados.dtos.SobreviventeDTO;
import com.api.controleinfectados.models.SobreviventeModel;
import com.api.controleinfectados.services.SobreviventeService;

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
@RequestMapping("/sobrevivente")
public class SobreviventeController {

	@Autowired
	private SobreviventeService sobreviventeService;
	
	@GetMapping
	public ResponseEntity<List<SobreviventeModel>> getAllSobreviventes(){
		return ResponseEntity.status(HttpStatus.OK).body(sobreviventeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getSobrevivente(@PathVariable(value = "id") Long id){
		Optional<SobreviventeModel> sobreviventeModelOptional = sobreviventeService.getById(id);
		if (!sobreviventeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sobrevivente não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(sobreviventeModelOptional.get());
	}
	
	@PostMapping
	public ResponseEntity<Object>saveSobrevivente(@RequestBody @Valid SobreviventeDTO sobreviventeDTO, UriComponentsBuilder uriBuilder){
		var sobreviventeModel = new SobreviventeModel();
		BeanUtils.copyProperties(sobreviventeDTO, sobreviventeModel);
		sobreviventeService.save(sobreviventeModel);
		URI uri = uriBuilder.path("sobrevivente/{id}").buildAndExpand(sobreviventeModel.getId()).toUri();
		return ResponseEntity.created(uri).body(sobreviventeModel);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateSobrevivente(@PathVariable(value="id") Long id,
												@RequestBody @Valid SobreviventeDTO sobreviventeDTO){
		Optional<SobreviventeModel> sobreviventeModelOptional = sobreviventeService.getById(id);
		if (!sobreviventeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sobrevivente não encontrado");
		}
		var sobreviventeModel = new SobreviventeModel();
		BeanUtils.copyProperties(sobreviventeDTO, sobreviventeModel);
		sobreviventeModel.setId(sobreviventeModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(sobreviventeService.save(sobreviventeModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSobrevivente(@PathVariable(value = "id") Long id){
		Optional<SobreviventeModel> sobreviventeModelOptional = sobreviventeService.getById(id);
		if(!sobreviventeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sobrevivente não encontrado");
		}
		sobreviventeService.delete(sobreviventeModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Sobrevivente deletado com sucesso!");
	}
	
}
