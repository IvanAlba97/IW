package es.reji.views.registration;

import es.reji.views.registration.domain.Registration;
import es.reji.views.registration.domain.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * A service class for the UI to access backend services.
 */
@Service
public
class RegistrationService {
    
    @Autowired
    private RegistrationRepository repository;
    private RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void register(Registration registration) {
        repository.save(registration);
    }

    public Optional<Registration> findById(Integer id) {
        return this.registrationRepository.findById(id);
    }

    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

}