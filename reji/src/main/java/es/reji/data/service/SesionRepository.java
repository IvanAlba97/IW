package es.reji.data.service;

import es.reji.data.entity.Sesion;
import es.reji.data.entity.Pelicula;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SesionRepository extends JpaRepository<Sesion, Integer> {
	Optional<Sesion> findById(Integer id);
	List<Sesion> findByPelicula(Optional<Pelicula> pelicula);
}