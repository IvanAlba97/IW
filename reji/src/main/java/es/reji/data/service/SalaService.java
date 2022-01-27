package es.reji.data.service;

import es.reji.data.entity.Sala;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
	
	public static final int SALAS_COUNT_LIMIT = 100;
	
	@SuppressWarnings("serial")
	public static class LimitReached extends RuntimeException {
    }

	private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }
    
    public List<Sala> findAll() {
        return salaRepository.findAll();
    }

    public int countAll() {
        return (int) salaRepository.count();
    }

    public Optional<Sala> findById(Integer id) {
        return this.salaRepository.findById(id);
    }

    public Sala findByNumSala(int numSala) {
        return this.salaRepository.findByNumSala(numSala);
    }

    public Sala save(Sala sala) {
        if (countAll() >= SALAS_COUNT_LIMIT) {
            throw new LimitReached();
        }

        return salaRepository.save(sala);
    }

    public void delete(Sala pelicula) {
        salaRepository.delete(pelicula);
    }

}
