package es.reji.data.service;

//import es.reji.data.entity.Sesion;
import es.reji.views.registration.domain.Registration;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
	
	public static final int PELICULAS_COUNT_LIMIT = 1000;
	
	@SuppressWarnings("serial")
	public static class LimitReached extends RuntimeException {
    }

	private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    
    //@Override
    //protected PeliculaRepository getRepository() {
    //    return repository;
    //}
    
    public List<Registration> findAll() {
        return loginRepository.findAll();
    }

    public int countAll() {
        return (int) loginRepository.count();
    }

    public Optional<Registration> findById(Integer id) {
        return this.loginRepository.findById(id);
    }

    /* public List<Sesion> findSesionById(Integer id){
        return this.peliculaRepository.findSesionById(id);
    } */

    //Para crea el CRUD
    //public List<Pelicula> findByNameContainingIgnoreCase(String titulo) {
    //    return peliculaRepository.findByNameContainingIgnoreCase(titulo);
    //}

    public Registration save(Registration pelicula) {
        if (countAll() >= PELICULAS_COUNT_LIMIT) {
            throw new LimitReached();
        }

        return loginRepository.save(pelicula);
    }

    public void delete(Registration pelicula) {
    	loginRepository.delete(pelicula);
    }

}

