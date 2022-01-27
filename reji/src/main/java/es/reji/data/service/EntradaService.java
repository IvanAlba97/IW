package es.reji.data.service;

import es.reji.data.entity.Entrada;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntradaService {
	
	@SuppressWarnings("serial")
	public static class LimitReached extends RuntimeException {
    }

	private final EntradaRepository entradaRepository;

    public EntradaService(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    public Optional<Entrada> findById(Integer id) {
        return this.entradaRepository.findById(id);
    }

    public void delete(Entrada entrada) {
        entradaRepository.delete(entrada);
    }

    public Entrada save(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

}
