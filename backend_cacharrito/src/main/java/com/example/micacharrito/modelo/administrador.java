package com.example.micacharrito.modelo;


import jakarta.persistence.Column; // establece los atributos de la entidad
import jakarta.persistence.Entity; // establece la entidad en la base de datos
import jakarta.persistence.Id; // establece que la entidad tiene una llave principal
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table; // estabece que se crea una tabla a la entidad

@Entity
@Table (name = "administrador")

public class administrador {
	
@Id
@Column(name = "IdAdmin", nullable = false )
private Long id;

@OneToOne()
@JoinColumn(name="IdPerfil",referencedColumnName="IdPerfil")
private usuario_Admin userAdmin;

public administrador() {
	super();
	// TODO Auto-generated constructor stub
}

public administrador(Long id, usuario_Admin userAdmin) {
	super();
	this.id = id;
	this.userAdmin = userAdmin;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public usuario_Admin getUserAdmin() {
	return userAdmin;
}

public void setUserAdmin(usuario_Admin userAdmin) {
	this.userAdmin = userAdmin;
}



}
