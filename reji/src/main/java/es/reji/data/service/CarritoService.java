package es.reji.data.service;

import es.reji.data.entity.Carrito;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {
	
	public static final int PELICULAS_COUNT_LIMIT = 1000;
	
	@SuppressWarnings("serial")
	public static class LimitReached extends RuntimeException {
    }

	private final CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> findById(Integer id) {
        return this.carritoRepository.findById(id);
    }

    public Carrito save(Carrito carrito) {
        return carritoRepository.save(carrito);
    }
}
