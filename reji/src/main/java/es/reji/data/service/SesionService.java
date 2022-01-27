package es.reji.data.service;

import es.reji.data.entity.Sesion;
import es.reji.data.entity.Pelicula;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SesionService {
	
	public static final int SESIONES_COUNT_LIMIT = 1000;
	
	@SuppressWarnings("serial")
	public static class LimitReached extends RuntimeException {
    }

	private final SesionRepository sesionRepository;

    public SesionService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }
    
    public List<Sesion> findAll() {
        return sesionRepository.findAll();
    }

    public int countAll() {
        return (int) sesionRepository.count();
    }

    public Optional<Sesion> findById(Integer id) {
        return this.sesionRepository.findById(id);
    }

    public List<Sesion> findByPelicula(Optional<Pelicula> pelicula)  {
        return this.sesionRepository.findByPelicula(pelicula);
    }

    public Sesion save(Sesion sesion) {
        if (countAll() >= SESIONES_COUNT_LIMIT) {
            throw new LimitReached();
        }

        return sesionRepository.save(sesion);
    }

    public void delete(Sesion sesion) {
        sesionRepository.delete(sesion);
    }

}
