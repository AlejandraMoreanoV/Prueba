package com.example.demo.controlador;

import com.example.demo.modelo.Estudiante;
import com.example.demo.servicio.ServicioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/controladorEstudiante")
public class ControladorEstudiante {

    @Autowired
    ServicioEstudiante servicioEstudiante;

    @GetMapping(path = "/mensajePrueba", produces = "application/json")
    public String mensajePrueba() {
        Estudiante e = new Estudiante("Alejandra", "Moreano", 15, 1);
        return servicioEstudiante.mensajePrueba(e);
    }

    @GetMapping(path = "/listarEstudiantes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Estudiante>> listarEstudiantes () {
        return new ResponseEntity<>(servicioEstudiante.listaEstudiantes, HttpStatus.OK);
    }

    @PostMapping(path = "/crearEstudiante", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearEstudiante (@RequestBody Estudiante e) {
        boolean respuesta = servicioEstudiante.crearEstudiante(e);
        if (respuesta) {
            return new ResponseEntity<>("Estudiante agregado correctamente.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error al agregar estudiante.", HttpStatus.CONFLICT);
    }

    @GetMapping(path = "/buscarEstudiante/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> buscarEstudiante (@PathVariable int id) {
        Estudiante estudiante = servicioEstudiante.buscarEstudiante(id);
        if (estudiante == null) {
            return new ResponseEntity("Error de ejecución.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

}