package com.example.nominaempleados.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.nominaempleados.modelo.Empleado;
import com.example.nominaempleados.modelo.Nomina;

public interface nomina_repositorio extends JpaRepository<Nomina, Long>{
	
	public Nomina findBySalario(Long salario);
	public Nomina findByDeducidos(Long deducidos);
	public Nomina findByFecha(Date fecha);
	public Nomina findByIngresos(Long ingresos);
	public Nomina findByTotalsal(Long totalsal);
	

	
	@Query(value= "Select n.id_empleado, SUM(total_salario) AS total_año FROM Nomina n " + 
			      "WHERE YEAR (n.fecha) = :año " +
	              "GROUP BY n.id_empleado ", nativeQuery = true)
	public List<Object> buscarTotalNomina(@Param("año") String año);
	
	
	
	@Query(value= "SELECT n.id_empleado, MONTH(n.fecha) AS mes, SUM(n.total_salario) AS total_mensual " +
	              "FROM Nomina n " +
			      "WHERE YEAR(n.fecha) = :month " +
			      "GROUP BY n.id_empleado, MONTH(n.fecha) " +
			      "ORDER BY n.id_empleado, mes", nativeQuery = true)
	
	public List<Object> buscarTotalMes(@Param("month")String month);

	
	
	@Query(value= "SELECT COUNT(DISTINCT n.id_empleado) AS cantidad_empleados " +
	              "FROM Nomina n " +
			      "WHERE YEAR(n.fecha) = :empl", nativeQuery = true)
	public List<Object> TotalCantidad(@Param("empl")String empl);
	
	
	@Query(value= "SELECT n.id_empleado, e.nombre, e.apellidos, COUNT(n.fecha) AS cantidad_pagos " +
	              "FROM Nomina n " +
			      "INNER JOIN Empleado e ON n.id_empleado = e.identificacion " +
	              "WHERE YEAR(n.fecha) = :pagos " +
			      "GROUP BY n.id_empleado, e.nombre, e.apellidos " +
	              "ORDER BY cantidad_pagos DESC", nativeQuery = true)
	public List<Object> PagosEmp(@Param("pagos") String pagos);
	
	
	
	
	@Query(value= "SELECT e.nombre, e.apellidos, SUM(n.total_salario) AS total_sueldo " + 
               "FROM Nomina n " +
               "INNER JOIN Empleado e ON n.id_empleado = e.identificacion " +
               "WHERE YEAR(n.fecha) = :suel " +
               "GROUP BY e.nombre, e.apellidos " +
               "ORDER BY total_sueldo DESC", nativeQuery = true)
    public List<Object> buscarCantidad(@Param("suel") String suel);
	
	
	@Query(value= "SELECT YEAR(n.fecha) AS año, MONTH(n.fecha) AS mes, " +
	              "AVG(n.total_salario) AS promedio_nom " +
			      "FROM Nomina n " +
	              "WHERE YEAR(n.fecha) = :nom " +
			      "GROUP BY año, mes " +
	              "ORDER BY año, mes", nativeQuery = true)
	public List<Object> pronmedioNomina(@Param("nom") String nom);

	
	@Query(value= "SELECT SUM(n.total_salario) AS total_nomina " +
                "FROM Nomina n " +
                "WHERE n.id_empleado = :idEmpleado " +
                "AND YEAR(n.fecha) = :año " +
                "AND MONTH(n.fecha) = :mes", nativeQuery = true)
    public List<Object> nom_total(@Param("idEmpleado") Long idEmpleado, @Param("año") String año, @Param("mes") String mes);
	
	public List<Nomina> findByEmpleadoIdentificacion(Long identificacion);
	
	
	public List<Nomina> findByEmpleadoIdentificacion(Empleado e);

	

	

	
	

}
