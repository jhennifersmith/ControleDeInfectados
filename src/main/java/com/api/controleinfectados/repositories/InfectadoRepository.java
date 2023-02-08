package com.api.controleinfectados.repositories;

import com.api.controleinfectados.models.InfectadoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfectadoRepository extends JpaRepository<InfectadoModel, Long>{

}
