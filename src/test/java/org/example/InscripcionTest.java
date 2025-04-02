package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionTest {

    @Test
    public void testInscripcionAprobadaSinCorrelativas() {
        Alumno alumno = new Alumno("Juan Pérez");
        Materia matematica = new Materia("Matemática Discreta"); // Materia sin correlativas

        List<Materia> materias = new ArrayList<>();
        materias.add(matematica);

        Inscripcion inscripcion = new Inscripcion(alumno, materias);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionAprobadaConCorrelativas() {
        Alumno alumno = new Alumno("Maria");

        // Configuración de materias y correlativas
        Materia algoritmos = new Materia("Algoritmos");
        Materia paradigmas = new Materia("Paradigmas");
        paradigmas.agregarCorrelativa(algoritmos);

        // Alumno aprueba la correlativa necesaria
        alumno.aprobarMateria(algoritmos);

        List<Materia> materias = new ArrayList<>();
        materias.add(paradigmas);

        Inscripcion inscripcion = new Inscripcion(alumno, materias);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionRechazadaPorFaltaCorrelativas() {
        Alumno alumno = new Alumno("Carlos");

        Materia algoritmos = new Materia("Algoritmos");
        Materia disenio = new Materia("Diseño de Sistemas");
        disenio.agregarCorrelativa(algoritmos);

        // Alumno NO aprueba algoritmos (correlativa necesaria)

        List<Materia> materias = new ArrayList<>();
        materias.add(disenio);

        Inscripcion inscripcion = new Inscripcion(alumno, materias);
        assertFalse(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionConMultiplesMaterias() {
        Alumno alumno = new Alumno("Ana");

        // Configuración de materias
        Materia algoritmos = new Materia("Algoritmos");
        Materia paradigmas = new Materia("Paradigmas");
        Materia disenio = new Materia("Diseño");
        Materia bases = new Materia("Bases de Datos");

        // Establecer correlativas
        paradigmas.agregarCorrelativa(algoritmos);
        disenio.agregarCorrelativa(paradigmas);
        bases.agregarCorrelativa(algoritmos);

        // Alumno aprueba solo algoritmos
        alumno.aprobarMateria(algoritmos);

        List<Materia> materias = new ArrayList<>();
        materias.add(paradigmas); // Necesita algoritmos (APROBADA)
        materias.add(bases);      // Necesita algoritmos (APROBADA)
        materias.add(disenio);    // Necesita paradigmas (RECHAZADA)

        Inscripcion inscripcion = new Inscripcion(alumno, materias);
        assertFalse(inscripcion.aprobada()); // Falla porque diseño no puede cursarse
    }}
