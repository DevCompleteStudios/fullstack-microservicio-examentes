package com.devstudios.microservicio.examenes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devstudios.microservicios.commons.examenes.entities.Examen;



public interface ExamenRepository extends JpaRepository<Examen, Long> {

    @Query("SELECT e FROM Examen e WHERE e.nombre LIKE %?1%")
    List<Examen> findByName( String name );

}
