package es.reji.data.service;

import es.reji.data.entity.Carrito;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
    
	Optional<Carrito> findById(Integer id);
}