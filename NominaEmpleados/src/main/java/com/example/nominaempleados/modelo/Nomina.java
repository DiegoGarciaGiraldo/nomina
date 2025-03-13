package com.example.nominaempleados.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Nomina")

public class Nomina {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "idNomina")
	
	private Long Id_nomina;
	
	@Column(name = "DiasTrabajo", nullable = false)
	private Long diasTrab;
	
	@Column(name= "Salario", nullable = false)
	private Long salario;
	
	@Column(name= "Deducibles", nullable = false)
	private Long deducidos;
	
	@Temporal(TemporalType.DATE) //para determinar si usa horas o fechas o ambas
	//@DateTimeFormat(iso = ISO.DATE) //para guardar solo la fecha
	@DateTimeFormat(pattern = "MM/dd/yyy")//Lo mismo pero se cambia el formato
	@Column(name = "Fecha", nullable = false)
	private Date fecha;
	
	@Column(name = "ingresos", nullable = false)
	private Long ingresos;
	
	@Column(name = "total_salario", nullable = false)
	private Long totalsal;
	
	
	@ManyToOne()
	@JoinColumn(name="identificacion",referencedColumnName="identificacion")
	private Empleado empleado;


	public Nomina() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Nomina(Long diasTrab, Long salario, Long deducidos, Date fecha, Long ingresos, Long totalsal,
			Empleado empleado) {
		super();
		this.diasTrab = diasTrab;
		this.salario = salario;
		this.deducidos = deducidos;
		this.fecha = fecha;
		this.ingresos = ingresos;
		this.totalsal = totalsal;
		this.empleado = empleado;
	}


	public Long getId_nomina() {
		return Id_nomina;
	}


	public void setId_nomina(Long id_nomina) {
		Id_nomina = id_nomina;
	}


	public Long getDiasTrab() {
		return diasTrab;
	}


	public void setDiasTrab(Long diasTrab) {
		this.diasTrab = diasTrab;
	}


	public Long getSalario() {
		return salario;
	}


	public void setSalario(Long salario) {
		this.salario = salario;
	}


	public Long getDeducidos() {
		return deducidos;
	}


	public void setDeducidos(Long deducidos) {
		this.deducidos = deducidos;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Long getIngresos() {
		return ingresos;
	}


	public void setIngresos(Long ingresos) {
		this.ingresos = ingresos;
	}


	public Long getTotalsal() {
		return totalsal;
	}


	public void setTotalsal(Long totalsal) {
		this.totalsal = totalsal;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
}
	
	


	