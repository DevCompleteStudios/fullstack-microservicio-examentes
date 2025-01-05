package com.devstudios.microservicio.examenes.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name = "examenes")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @JsonIgnoreProperties(value = {"examen"}, allowGetters = true)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "examen")
    private List<Pregunta> preguntas = new ArrayList<>();

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas.clear(); // para no perder la referencia
        preguntas.forEach(this::addPregunta);
    }
    public void addPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
        pregunta.setExamen(this);
    }
    public void removePregunta(Pregunta pregunta) {
        this.preguntas.remove(pregunta);
        pregunta.setExamen(null);
    }

}
