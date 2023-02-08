package com.api.controleinfectados.models;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel implements UserDetails{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "ID_USUARIO", nullable = false )
	private Long id;
	@Column( name = "LOGIN_USUARIO", nullable = false )
	private String login;
	@Column( name = "SENHA_USUARIO", nullable = false )
	private String senha;
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(name = "TB_USERS_ROLES",
				joinColumns = @JoinColumn(name = "ID_USUARIO"),
				inverseJoinColumns = @JoinColumn(name = "ID_ROLE"))
	private List<RoleModel> roles;
	
	@Transactional
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}
	@Override
	public String getPassword() {
		return senha;
	}
	@Override
	public String getUsername() {
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
