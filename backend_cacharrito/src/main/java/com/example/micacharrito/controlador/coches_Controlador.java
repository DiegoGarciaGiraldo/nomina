package com.example.micacharrito.controlador;

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

import com.example.micacharrito.modelo.coches;
import com.example.micacharrito.repositorio.coches_Repositorio;


@RestController
@RequestMapping("/ver/coches/")
@CrossOrigin(origins = "http://localhost:4200/")

public class coches_Controlador {
	
	@Autowired
	private coches_Repositorio repcoches;
	
	@GetMapping("/ListaCoches")
	public List<coches> listacoches(
			@RequestParam String estado
			){
		return this.repcoches.findByEstado(estado);
		
	}
	
	
	
	
	
	
	

	
	

}
