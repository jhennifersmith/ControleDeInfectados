package com.api.controleinfectados.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_INFECTADOS")
public class InfectadoModel {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "ID_INFECTADO", nullable = false )
	private Long id;

	@Column( name = "NOME_INFECTADO", nullable = false )
	private String nome;
	
	@Column( name = "APARENCIA_INFECTADO", nullable = false )
	private String aparencia;
	
	@Column( name = "COMPORTAMENTO_INFECTADO", nullable = false )
	private String comportamento;
	
}
