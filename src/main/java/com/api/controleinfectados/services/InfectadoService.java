package com.api.controleinfectados.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.api.controleinfectados.models.InfectadoModel;
import com.api.controleinfectados.repositories.InfectadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfectadoService {

	@Autowired
	private InfectadoRepository infectadoRepository;
	
	public List<InfectadoModel> findAll(){
		return infectadoRepository.findAll();
	}
	
	public Optional<InfectadoModel> getById (Long id) {
		return infectadoRepository.findById(id);
	}
	
	@Transactional
	public InfectadoModel save (InfectadoModel infectadoModel) {
		return infectadoRepository.save(infectadoModel);
	}
	
	@Transactional
	public void delete(InfectadoModel infectadoModel) {
		infectadoRepository.delete(infectadoModel);
	}
	
}
