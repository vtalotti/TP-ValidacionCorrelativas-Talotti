package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.util.List;

public class AlumnoTest {

    @Test
    public void testCrearAlumno() {
        Alumno alumno = new Alumno("Juan");
        assertEquals("Juan ", alumno.getNombre());
        assertTrue(alumno.getMateriasAprobadas().isEmpty());
    }

    @Test
    public void testAprobarMateria() {
        Alumno alumno = new Alumno("María");
        Materia algoritmos = new Materia("Algoritmos");

        alumno.aprobarMateria(algoritmos);

        List<Materia> aprobadas = alumno.getMateriasAprobadas();
        assertEquals(1, aprobadas.size());
        assertEquals("Algoritmos", aprobadas.get(0).getNombre());
    }

    @Test
    public void testTieneAprobada() {
        Alumno alumno = new Alumno("Carlos");
        Materia paradigmas = new Materia("Paradigmas");
        Materia matematica = new Materia("Matemática");

        alumno.aprobarMateria(paradigmas);

        assertTrue(alumno.tieneAprobada(paradigmas));
        assertFalse(alumno.tieneAprobada(matematica));
    }

    @Test
    public void testAprobarMultiplesMaterias() {
        Alumno alumno = new Alumno("Ana");
        Materia m1 = new Materia("Algoritmos");
        Materia m2 = new Materia("Paradigmas");
        Materia m3 = new Materia("Diseño");

        alumno.aprobarMateria(m1);
        alumno.aprobarMateria(m2);
        alumno.aprobarMateria(m3);

        assertEquals(3, alumno.getMateriasAprobadas().size());
    }
}
