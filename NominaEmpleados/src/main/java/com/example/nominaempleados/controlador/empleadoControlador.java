package com.example.nominaempleados.controlador;

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
@RequestMapping("/ver/empleado/")
@CrossOrigin(origins = "http://localhost:4200/")

public class empleadoControlador {

	@Autowired
	private empleado_repositorio repositorio;
	
	
	@Autowired
	private nomina_repositorio nomirep;
	
	@GetMapping("/Lista_empleado")
	public List<Empleado> verTodosEmpleados(){
		return repositorio.findAll();
	}
	
	@GetMapping("/Guardar_empleados")
	public Optional<Empleado> guardar(){
		
		Empleado e = new Empleado((long)12345,"Brayan","Salanas","Brayan@amail.com");
		this.repositorio.save(e);
		
		return this.repositorio.findById((long) 12345);
		
	}
	
	@GetMapping("/Save_empleados")
	public Optional<Empleado> guardar_nuevo(){
		
		Empleado e = new Empleado((long)123455,"Diego","Garcia","Diego@amail.com");
		this.repositorio.save(e);
		
		return this.repositorio.findById((long) 123455);
		
	}
	
	@GetMapping("/Buscar_empleado")
	public Optional<Empleado> buscar(){
		return this.repositorio.findById((long) 12345);
	}
	
	@GetMapping("/Eliminar_empleado")
	public boolean eliminar() {
		
		this.repositorio.deleteById((long)123455);
		
		return true;
	}
	
	@GetMapping("/Actualizar_empleado")
	public boolean actualizar() {
		
		Empleado emp = this.repositorio.findById((long)12345).get();
		
		emp.setApellidos("Monteria");
		
		this.repositorio.save(emp);
		
		return true;
		
		
	}
	
	@GetMapping("/Buscar_nombre")
	public List<Empleado> buscar_nombre() {
		this.repositorio.findByNombre("Diego");
		return repositorio.findAll();
	}
	
	@GetMapping("/Buscar_apellidos")
	public List<Empleado> buscar_apellidos() {
		this.repositorio.findByApellidos("Salanas");
		return  repositorio.findAll(); 
	}
	
	@GetMapping("/Buscar_correo")
	public List<Empleado> buscar_email(){
		this.repositorio.findByEmail("Diego@amail.com");
		return  repositorio.findAll(); 
		
	}
	
	@GetMapping("/buscarEmpleadoNomina")
	public List<Object> buscarNomina(){
		return this.repositorio.buscarNominaE(123455L);
		}
	
	
	 @PostMapping("/guardar")
	 public Empleado guardarEmpleado(
			 @RequestBody Empleado e
			 ) {
		 return this.repositorio.save(e);
	 }
	 
	 @PostMapping("/buscarId")
	 public Empleado buscarId(
		@RequestBody Long identificacion
		){
		 
		 return this.repositorio.findByIdentificacion(identificacion);
		
	 }
	 
	
	 @GetMapping("/borrarEmpleadoId")
		public Optional<Empleado> eliminarEmpleado(@RequestParam Long identificacion ){
			Empleado e = this.repositorio.findById(identificacion).get();
			List <Nomina> nE= this.nomirep.findByEmpleadoIdentificacion(e);
			for(int i=0;i<nE.size();i++) {
				this.nomirep.deleteById(nE.get(i).getId_nomina());
			}
				
			this.repositorio.deleteById(identificacion);
		 return Optional.empty();
		}
	 
	 @PostMapping("/update")
	 public Empleado actualizarEmpleado(
			 @RequestBody Empleado e
			 ) {
		 return this.repositorio.save(e);
	 }
	 
	 

	 
	 

}
