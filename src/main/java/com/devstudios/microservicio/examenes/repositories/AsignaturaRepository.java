package com.devstudios.microservicio.examenes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devstudios.microservicios.commons.examenes.entities.Asignatura;



public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {}
