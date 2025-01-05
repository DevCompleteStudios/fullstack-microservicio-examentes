package com.devstudios.microservicio.examenes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devstudios.microservicio.examenes.repositories.AsignaturaRepository;
import com.devstudios.microservicio.examenes.repositories.ExamenRepository;
import com.devstudios.microservicios.app.commons.services.CommonServiceImpl;
import com.devstudios.microservicios.commons.examenes.entities.Asignatura;
import com.devstudios.microservicios.commons.examenes.entities.Examen;




@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public List<Examen> findByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public List<Asignatura> findAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

}

