package es.reji.data.service;

import es.reji.data.entity.Cine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CineRepository extends JpaRepository<Cine, Integer> {
    Cine findByDireccion(String direccion);
}
