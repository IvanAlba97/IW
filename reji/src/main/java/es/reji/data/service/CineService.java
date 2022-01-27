package es.reji.data.service;

import es.reji.data.entity.Cine;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CineService {

	public static final int CINES_COUNT_LIMIT = 1000;
	
	@SuppressWarnings("serial")
	public static class LimitReached extends RuntimeException {
    }
	
	private final CineRepository cineRepository;

    public CineService(CineRepository cineRepository) {
        this.cineRepository = cineRepository;
    }
    
    //@Override
    //protected CineRepository getRepository() {
    //    return repository;
    //}
    
    public List<Cine> findAll() {
        return cineRepository.findAll();
    }

    public int countAll() {
        return (int) cineRepository.count();
    }

    public Optional<Cine> findById(Integer id) {
        return this.cineRepository.findById(id);
    }
    
    public Cine save(Cine cine) {
        if (countAll() >= CINES_COUNT_LIMIT) {
            throw new LimitReached();
        }

        return cineRepository.save(cine);
    }

    public void delete(Cine cine) {
        cineRepository.delete(cine);
    }


}
