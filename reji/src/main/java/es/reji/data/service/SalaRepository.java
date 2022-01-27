package es.reji.data.service;

import es.reji.data.entity.Sala;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SalaRepository extends JpaRepository<Sala, Integer> {
    
	Sala findByNumSala(int numSala);
	Optional<Sala> findById(Integer id);
	
}