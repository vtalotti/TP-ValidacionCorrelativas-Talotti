package org.example;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativa(Materia materia) {               //para testear
        this.correlativas.add(materia);
    }

    public boolean puedeCursar(Alumno alumno) {
        for (Materia correlativa : correlativas) {
            if (!alumno.tieneAprobada(correlativa)) {
                return false;
            }
        }
        return true;
    }
    public String getNombre() {
        return nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
}}
