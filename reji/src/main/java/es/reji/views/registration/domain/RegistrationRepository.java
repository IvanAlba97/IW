package es.reji.views.registration.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Empty JpaRepository is enough for a simple crud.
 */
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Optional<Registration> findById(Integer id);
    
}