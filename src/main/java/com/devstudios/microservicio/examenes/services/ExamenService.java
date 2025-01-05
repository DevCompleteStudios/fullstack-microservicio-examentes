package com.devstudios.microservicio.examenes.services;

import java.util.List;

import com.devstudios.microservicios.app.commons.services.CommonService;
import com.devstudios.microservicios.commons.examenes.entities.Examen;



public interface ExamenService extends CommonService<Examen> {

    List<Examen> findByName( String name );

}
