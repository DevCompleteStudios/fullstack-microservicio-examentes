package com.devstudios.microservicio.examenes.services;

import org.springframework.stereotype.Service;

import com.devstudios.microservicio.examenes.repositories.ExamenRepository;
import com.devstudios.microservicios.app.commons.services.CommonServiceImpl;
import com.devstudios.microservicios.commons.examenes.entities.Examen;




@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {}

