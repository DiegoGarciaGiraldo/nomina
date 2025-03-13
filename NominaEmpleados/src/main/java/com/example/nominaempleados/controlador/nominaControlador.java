package com.example.nominaempleados.controlador;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.nominaempleados.modelo.Empleado;
import com.example.nominaempleados.modelo.Nomina;
import com.example.nominaempleados.repositorio.empleado_repositorio;
import com.example.nominaempleados.repositorio.nomina_repositorio;

@RestController
@RequestMapping("/ver/nomina")
@CrossOrigin(origins = "http://localhost:4200/")

public class nominaControlador {
	
	@Autowired
	private nomina_repositorio nomirep;
	
	@Autowired
	private empleado_repositorio repositorio;
	
	@GetMapping("/Ver_Nomina")
	public List<Nomina>nomina(){
		return nomirep.findAll();
	}
	
	@GetMapping("/Guardar_Nomina")
	public List<Nomina> guardar_nomina(
			
			@RequestParam Long diasTrab,
			@RequestParam Long salario,
			@RequestParam Long deducidos,
			@RequestParam String fechae,
			@RequestParam Long ingresos,
			@RequestParam Long totalsal,
			@RequestParam Empleado empleado
			
			
			) throws ParseException{ //el metodo puede lanzar 
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		//debe de haber una mascara adentro del metodo
		//kis "/" pueden ser reemplazados con "-"
		
		
		Date fecha = sdf.parse(fechae); //se castea los caracteres a fecha
		
		Nomina empl = new Nomina(diasTrab, salario, deducidos, fecha, ingresos, totalsal, empleado);
		
		this.nomirep.save(empl);
		
		return this.nomirep.findAll();
	}
	
	
	@GetMapping("/Buscar_nomina")
	public Optional<Nomina>buscar_nom(){
		return this.nomirep.findById((long)1);
		
	}
	
	@GetMapping("/Actualizar_nomina")
	public boolean actualizar() {
		
		Nomina nom = this.nomirep.findById((long)1).get();
		
		nom.setIngresos((long) 40000);
		
		this.nomirep.save(nom);
		
		return true;
		
		
	}
	
	
	@GetMapping("/Eliminar_nomina")
	public boolean eliminar_nomina() {
		
		this.nomirep.deleteById((long)11);
		
		return true;
		
	}
	
	
	@GetMapping("/Buscar_salario")
	public List<Nomina> buscar_salario() {
		this.nomirep.findBySalario((long)300000);
		return nomirep.findAll();
	}
	
	@GetMapping("/Buscar_deducidos")
	public List<Nomina> buscar_deducidos() {
		this.nomirep.findByDeducidos((long)30);
		return nomirep.findAll(); 
	}
	
	@GetMapping("/Buscar_ingresos")
	public List<Nomina> buscar_ingresos() {
		this.nomirep.findByIngresos((long)30000);
		return nomirep.findAll();
	}
	
	@GetMapping("/Buscar_totalsal")
	public List<Nomina> buscar_totalsal() {
		this.nomirep.findByTotalsal((long)270000);
		return nomirep.findAll();
	}
	
	
//Actividad
	
	//1
	
	@GetMapping("/Total_nomina")
	public List<Object> total_salario(){
		return this.nomirep.buscarTotalNomina("2025");
		
	}
	
	//2
	@GetMapping("/Total_mes")
	public List<Object> total_mes(){
		return this.nomirep.buscarTotalMes("2025-02-28");
	

	}
	
	//3
	@GetMapping("/Total_cantidad")
	public List<Object> cantidad_empl(){
		return this.nomirep.TotalCantidad("2025");
		
	}
	
	
	//4
	@GetMapping("/Pagos")
	public List<Object> Pagos_Empleado(){
		return this.nomirep.PagosEmp("2025");
		
	}
	
	
	//5
	@GetMapping("/Mas_pagado")
	public List<Object> mas_pagado(){
		return this.nomirep.buscarCantidad("2025");
		
	}	
	
	//6
	@GetMapping("/promedio")
	public List<Object> promedio_nomina(){
		return this.nomirep.pronmedioNomina("2025");
		
	}
	
	//7
	@GetMapping("/total_mes_espec")
	public List<Object> nomina_total(){
		return this.nomirep.nom_total(123455L,"2025","03");
		
	}
	
	
	
	//Actividad
	
	//1
	
	@GetMapping("/Calcular_Nomina")
	public List<Nomina> Calcular(
			
			@RequestParam Long diasTrab,              
			@RequestParam Long salario,
			@RequestParam Long deducidos,
			@RequestParam String fechae,
			@RequestParam Long ingresos,
			@RequestParam Empleado empleado
			
			
		) throws ParseException{ //el metodo puede lanzar 
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		//debe de haber una mascara adentro del metodo
		//kis "/" pueden ser reemplazados con "-"
		Date fecha = sdf.parse(fechae); //se castea los caracteres a fecha
		
		
		
		float descuento = (float) (salario * 0.10);
		float salarioDescuento = salario - descuento;
		
		float smmlv = 1450000*2;
		float bonificacion;
		if (salario <= smmlv) {
			bonificacion = (float) (salario * 0.10);
		}else {
			bonificacion = 0;
		}
		
		float totalSalario = salarioDescuento + bonificacion + ingresos;
		
		
		Nomina empl = new Nomina(diasTrab, salario, deducidos, fecha, ingresos,(long) totalSalario, empleado);
		
		this.nomirep.save(empl);
		
		return this.nomirep.findAll();
		
	}
	
	//2
	
	//a
	
	@GetMapping("/calcular_parafiscales")
	public String calcular_parafiscales(
			@RequestParam Long identificacion,
			@RequestParam Long salario
			) {
		
		float parafICBF = (float) (salario * 0.03);
		float parafSENA = (float) (salario * 0.02);
		float parafCajasCompensacion = (float) (salario * 0.04);
		
		float totalParafiscales = (float) (parafICBF + parafSENA + parafCajasCompensacion);
		
		return "Los parafiscales del empleado con ID " + identificacion + " y salario de $" + salario + 
				" son: " + "ICBF: $" + parafICBF + "\n"+
		        " SENA: $" + parafSENA + "\n" +
				" Caja de compensacion familiar: $" + parafCajasCompensacion + "\n" +
		        " Total de parafiscales: $" + totalParafiscales;
		
		
		
	}
	
	//b
	
	@GetMapping("/total_parafiscales")
	public String total_parafiscales() {
	
	List<Nomina> nominas = nomirep.findAll();
	
	float totalPara = 0;
	
	for (int i = 0; i < nominas.size(); i++) {
		totalPara += nominas.get(i).getSalario()* 0.09;
	}
	
	return "El total de parafiscales a pagar por todos los empleado es: " + totalPara;
	
	
	}
	
	//3
	@GetMapping("/Cesantias")
	public String calcularCesantias(
			@RequestParam Long identificacion
			) {
		List<Nomina> nominas = nomirep.findByEmpleadoIdentificacion(identificacion);
		
		
		float totalCesan = 0;
		
		for(int i = 0; i < nominas.size(); i++) {
			totalCesan += nominas.get(i).getSalario();
		}
		
		
		float interesesCesan = (float) (totalCesan * 0.12 * (360/360));
		
		float totalPagar = totalCesan + interesesCesan;
		
		return "El empleado con ID " + identificacion + " tiene Cesantias:$ " + totalCesan + "Intereses de cesantias: $" + interesesCesan +
		       "Total a pagar: $" + totalPagar;
	}
	
	

	
	
}
