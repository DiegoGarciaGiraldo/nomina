package com.example.micacharrito.modelo;

import jakarta.persistence.Column; // establece los atributos de la entidad
import jakarta.persistence.Entity; // establece la entidad en la base de datos
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // establece que la entidad tiene una llave principal
import jakarta.persistence.Table; // estabece que se crea una tabla a la entidad

@Entity
@Table(name = "Usuario_Admin")

public class usuario_Admin {
	

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "IdPerfil")
	private Long IdPerfil;
	
	@Column(name = "Usuario", nullable = false)
	private String usuario;
	
	@Column(name= "Password", nullable = false)
	private String password;

	public usuario_Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public usuario_Admin(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public Long getIdPerfil() {
		return IdPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		IdPerfil = idPerfil;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

	
	

}
