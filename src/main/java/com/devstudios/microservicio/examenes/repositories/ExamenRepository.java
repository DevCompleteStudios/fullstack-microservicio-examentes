package com.devstudios.microservicio.examenes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devstudios.microservicio.examenes.models.entities.Examen;



public interface ExamenRepository extends JpaRepository<Examen, Long> {}
