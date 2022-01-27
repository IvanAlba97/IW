package es.reji.data.service;

import es.reji.views.registration.domain.Registration;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Registration, Integer> {
    
	Registration findByName(String name);
	Optional<Registration> findById(Integer id);
	//List<Sesion> findSesionById(Integer id);
	//CRUD
	//List<Pelicula> findByNameContainingIgnoreCase(String titulo);
}