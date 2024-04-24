package com.example.demo.servicio;

import com.example.demo.modelo.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioEstudiante {

    //public String nombreProgramaAcademico;

    public List<Estudiante> listaEstudiantes = new ArrayList<>();

    public String mensajePrueba (Estudiante e) {
        return e.getNombre() + " " + e.getApellido() + " se ha inscrito al programa.";
    }

    public Estudiante crearEstudiante (Estudiante estudiante) {
        Estudiante e = buscarEstudiante(estudiante.getId());
        if (estudiante.getId() >= 0
                && estudiante.getNombre() != null
                && !estudiante.getNombre().isEmpty()
                && estudiante.getApellido() != null
                && !estudiante.getApellido().isEmpty()
                && e == null) {
            listaEstudiantes.add(estudiante);
            return estudiante;
        }
        return null;
    }

    public Estudiante buscarEstudiante(int id) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getId()==id) {
                return e;
            }
        }
        return null;
    }

    public Estudiante actualizarEstudiante(int id, Estudiante estudiante) {
        Estudiante e = buscarEstudiante(id);
        if (e == null) {
            return null;
        } else if (estudiante.getNombre() != null
                && !estudiante.getNombre().isEmpty()
                && estudiante.getApellido() != null
                && !estudiante.getApellido().isEmpty()) {
            e.setNombre(estudiante.getNombre());
            e.setApellido(estudiante.getApellido());
            return e;
        } else {
            return null;
        }
    }

    public Estudiante eliminarEstudiante(int id) {
        Estudiante e = buscarEstudiante(id);
        if (e == null) {
            return null;
        } else {
            listaEstudiantes.remove(e);
            return e;
        }
    }

    public List<Estudiante> listarEstudiantes() {
        return listaEstudiantes;
    }

}