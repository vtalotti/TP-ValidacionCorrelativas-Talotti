package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creación de materias
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        Materia diseño = new Materia("Diseño de Sistemas");

        // Establecer correlativas
        paradigmas.agregarCorrelativa(algoritmos);
        diseño.agregarCorrelativa(paradigmas);

        // Creación de alumno
        Alumno juan = new Alumno("Juan Perez");
        juan.aprobarMateria(algoritmos);
        juan.aprobarMateria(paradigmas);

        // Creación de inscripción
        List<Materia> materiasACursar = new ArrayList<>();
        materiasACursar.add(diseño);

        Inscripcion inscripcion = new Inscripcion(juan, materiasACursar);

        // Validar inscripción
        if (inscripcion.aprobada()) {
            System.out.println("La inscripción fue aprobada");
        } else {
            System.out.println("La inscripción fue rechazada");
        }
    }
}
