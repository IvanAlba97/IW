package es.reji.data.service;

import es.reji.data.entity.Pelicula;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    
	Pelicula findByTitulo(String titulo);
	Optional<Pelicula> findById(Integer id);
	//List<Sesion> findSesionById(Integer id);
	//CRUD
	//List<Pelicula> findByNameContainingIgnoreCase(String titulo);
}