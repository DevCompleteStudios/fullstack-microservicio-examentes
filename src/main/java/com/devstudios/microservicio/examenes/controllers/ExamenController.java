package com.devstudios.microservicio.examenes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devstudios.microservicio.examenes.models.entities.Examen;
import com.devstudios.microservicio.examenes.models.entities.Pregunta;
import com.devstudios.microservicio.examenes.services.ExamenService;
import com.devstudios.microservicios.app.commons.controllers.CommonController;




@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar( @PathVariable Long id, @RequestBody Examen examen ){
        Optional<Examen> opt = this.service.findById(id);
        if( opt.isEmpty() ) return ResponseEntity.notFound().build();

        Examen examenDb = opt.get();
        if( examen.getNombre() != null) examenDb.setNombre(examen.getNombre());

        examenDb.getPreguntas()
            .stream()
            .filter(p -> !examen.getPreguntas().contains(p))
            .forEach(examenDb::removePregunta);

        examenDb.setPreguntas(examen.getPreguntas());
        return ResponseEntity.status(201).body(this.service.save(examenDb));
    }

}