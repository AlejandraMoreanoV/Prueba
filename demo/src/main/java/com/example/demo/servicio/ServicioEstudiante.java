package com.example.demo.servicio;

import com.example.demo.modelo.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioEstudiante {

    //public String nombreProgramaAcademico;

    public ArrayList<Estudiante> listaEstudiantes;

    public ServicioEstudiante(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public String mensajePrueba (Estudiante e) {
        return e.getNombre() + " " + e.getApellido() + " se ha inscrito al programa.";
    }

    public boolean crearEstudiante (Estudiante e) {
        if (listaEstudiantes.add(e)) {
            return true;
        }
        return false;
    }

    public Estudiante buscarEstudiante(int id) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getId()==id) {
                return e;
            }
        }
        return null;
    }

}