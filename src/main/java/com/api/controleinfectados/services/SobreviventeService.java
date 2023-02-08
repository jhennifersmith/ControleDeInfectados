package com.api.controleinfectados.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.api.controleinfectados.models.SobreviventeModel;
import com.api.controleinfectados.repositories.SobreviventeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SobreviventeService {

	@Autowired
	private SobreviventeRepository sobreviventeRepository;
	
	public List<SobreviventeModel> findAll(){
		return sobreviventeRepository.findAll();
	}
	
	public Optional<SobreviventeModel> getById (Long id) {
		return sobreviventeRepository.findById(id);
	}
	
	@Transactional
	public SobreviventeModel save (SobreviventeModel sobreviventeModel) {
		return sobreviventeRepository.save(sobreviventeModel);
	}
	
	@Transactional
	public void delete(SobreviventeModel sobreviventeModel) {
		sobreviventeRepository.delete(sobreviventeModel);
	}
	
}
