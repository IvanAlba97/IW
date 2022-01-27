package es.reji.data.service;

import es.reji.data.entity.Pelicula;
//import es.reji.data.entity.Sesion;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
	
	public static final int PELICULAS_COUNT_LIMIT = 1000;
	
	@SuppressWarnings("serial")
	public static class LimitReached extends RuntimeException {
    }

	private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }
    
    //@Override
    //protected PeliculaRepository getRepository() {
    //    return repository;
    //}
    
    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    public int countAll() {
        return (int) peliculaRepository.count();
    }

    public Optional<Pelicula> findById(Integer id) {
        return this.peliculaRepository.findById(id);
    }

    /* public List<Sesion> findSesionById(Integer id){
        return this.peliculaRepository.findSesionById(id);
    } */

    //Para crea el CRUD
    //public List<Pelicula> findByNameContainingIgnoreCase(String titulo) {
    //    return peliculaRepository.findByNameContainingIgnoreCase(titulo);
    //}

    public Pelicula save(Pelicula pelicula) {
        if (countAll() >= PELICULAS_COUNT_LIMIT) {
            throw new LimitReached();
        }

        return peliculaRepository.save(pelicula);
    }

    public void delete(Pelicula pelicula) {
        peliculaRepository.delete(pelicula);
    }

}
