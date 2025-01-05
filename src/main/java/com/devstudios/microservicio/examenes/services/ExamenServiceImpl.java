package com.devstudios.microservicio.examenes.services;

import org.springframework.stereotype.Service;

import com.devstudios.microservicio.examenes.models.entities.Examen;
import com.devstudios.microservicio.examenes.repositories.ExamenRepository;
import com.devstudios.microservicios.app.commons.services.CommonServiceImpl;




@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {}

