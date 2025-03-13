package com.example.nominaempleados.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.nominaempleados.modelo.Empleado;


public interface empleado_repositorio extends JpaRepository<Empleado, Long>{
	
	public Empleado findByIdentificacion(Long identificacion);
	public Empleado findByNombre(String nombre);
	public Empleado findByApellidos(String apellidos);
	public Empleado findByEmail(String email);
	
	
	@Query(value="Select e.nombre, e.apellidos, n.fecha, n.salario from Empleado e inner join"
           + " Nomina n on e.identificacion = n.id_empleado and e.identificacion =:idEmpleado",
	       nativeQuery = true)
	public List<Object> buscarNominaE(@Param("idEmpleado")long idEmpleado);



}
