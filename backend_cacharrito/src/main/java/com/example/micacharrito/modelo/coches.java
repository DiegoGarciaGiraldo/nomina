package com.example.micacharrito.modelo;

import jakarta.persistence.Column; // establece los atributos de la entidad
import jakarta.persistence.Entity; // establece la entidad en la base de datos
import jakarta.persistence.Id; // establece que la entidad tiene una llave principal
import jakarta.persistence.Table; // estabece que se crea una tabla a la entidad

@Entity
@Table (name = "coches")

public class coches {
	
	@Id
	@Column(name = "Placa")
	private String placa;
	
	@Column(name = "Color", nullable = false)
	private String color;
	
	@Column(name = "TipoVehiculo", nullable = false)
	private String tipoVeh;
	
	@Column(name = "Estado", nullable = false)
	private String estado;
	
	@Column(name = "ValorAlquiler", nullable = false)
	private float valorAlq;

	public coches() {
		super();
		// TODO Auto-generated constructor stub
	}

	public coches(String placa, String color, String tipoVeh, String estado, float valorAlq) {
		super();
		this.placa = placa;
		this.color = color;
		this.tipoVeh = tipoVeh;
		this.estado = estado;
		this.valorAlq = valorAlq;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipoVeh() {
		return tipoVeh;
	}

	public void setTipoVeh(String tipoVeh) {
		this.tipoVeh = tipoVeh;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getValorAlq() {
		return valorAlq;
	}

	public void setValorAlq(float valorAlq) {
		this.valorAlq = valorAlq;
	}
	
	
	
	
	

}
