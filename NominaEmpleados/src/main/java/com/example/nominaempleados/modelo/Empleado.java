package com.example.nominaempleados.modelo;

import jakarta.persistence.Column; // establece los atributos de la entidad
import jakarta.persistence.Entity; // establece la entidad en la base de datos
import jakarta.persistence.Id; // establece que la entidad tiene una llave principal
import jakarta.persistence.Table; // estabece que se crea una tabla a la entidad

@Entity
@Table (name = "empleado")

public class Empleado {
	
	@Id
	@Column(name = "identificacion")
	private Long identificacion;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name = "apellidos", length = 80, nullable = false)
	private String apellidos;
	
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(Long id, String nombre, String apellidos, String email) {
		super();
		this.identificacion = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}

	public Long getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(Long id) {
		this.identificacion = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getsalario() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	
	

}
