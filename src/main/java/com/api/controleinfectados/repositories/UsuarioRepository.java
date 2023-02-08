package com.api.controleinfectados.repositories;

import com.api.controleinfectados.models.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	UserDetails findByLogin(String username);

}
