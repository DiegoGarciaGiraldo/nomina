package com.example.micacharrito.repositorio;

import com.example.micacharrito.modelo.usuario_Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface usuario_Admin_Repositorio extends JpaRepository<usuario_Admin, Long>{

	Optional<usuario_Admin> findByUsuario(String usuario);

}
