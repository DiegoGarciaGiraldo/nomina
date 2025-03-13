package com.example.micacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micacharrito.modelo.coches;

public interface coches_Repositorio extends JpaRepository<coches, String>{

	List<coches> findByEstado(String estado);

	

}
