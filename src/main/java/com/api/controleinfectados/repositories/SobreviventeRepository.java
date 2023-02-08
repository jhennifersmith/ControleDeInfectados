package com.api.controleinfectados.repositories;

import com.api.controleinfectados.models.SobreviventeModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobreviventeRepository extends JpaRepository<SobreviventeModel, Long> {

}
