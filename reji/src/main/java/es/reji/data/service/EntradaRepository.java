package es.reji.data.service;

import es.reji.data.entity.Entrada;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
    
	Optional<Entrada> findById(Integer id);
	
}
