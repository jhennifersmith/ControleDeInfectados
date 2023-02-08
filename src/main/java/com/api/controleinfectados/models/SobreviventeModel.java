package com.api.controleinfectados.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.api.controleinfectados.enums.EstadoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_SOBREVIVENTES")
public class SobreviventeModel {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "ID_SOBREVIVENTE", nullable = false )
	private Long id;

	@Column( name = "NOME_SOBREVIVENTE", nullable = false )
	private String nome;
	
	@Column( name = "IDADE_SOBREVIVENTE", nullable = false )
	private Long idade;
	
	@Column( name = "FILIACAO_SOBREVIVENTE", nullable = false )
	private String filiacao;
	
	@Enumerated(EnumType.STRING)
	@Column( name = "ESTADO_SOBREVIVENTE", nullable = false )
	private EstadoEnum estado;
	
}
