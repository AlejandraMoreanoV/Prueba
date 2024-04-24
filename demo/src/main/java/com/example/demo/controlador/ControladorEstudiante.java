package com.example.demo.controlador;

import com.example.demo.modelo.Estudiante;
import com.example.demo.servicio.ServicioEstudiante;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "TAT")
//@Api(tags = "TAT", descripcion = "Métodos para la API.")

@RestController
@RequestMapping(value = "/estudiante")

public class ControladorEstudiante {

    @Autowired
    ServicioEstudiante servicioEstudiante;

    @ApiOperation(value = "EndPoint para mostrar un saludo")
    @GetMapping(path = "/mensajePrueba")
    public String mensajePrueba() {
        //Estudiante e = new Estudiante(1, "Alejandra", "Moreano");
        return ("EXPOSICIÓN TAT - SOFTWARE II");
    }

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante (@RequestBody Estudiante estudiante) {
        if (estudiante.getId()<= 0
                || estudiante.getNombre()==null
                || estudiante.getNombre().isEmpty()
                || estudiante.getApellido()==null
                || estudiante.getApellido().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Información inválida, por favor corregir.");
        }
        Estudiante e = servicioEstudiante.crearEstudiante(estudiante);
        if (e == null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El ID que intenta ingresar ya ha sido asignado.");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(e);
        }
    }

    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<Estudiante> buscarEstudiante (@PathVariable int id) {
        try {
            Estudiante estudiante = servicioEstudiante.buscarEstudiante(id);
            if (estudiante == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(estudiante);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(estudiante);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping (path = "/{id}")
    public ResponseEntity<Estudiante> actualizarUsuario (@RequestParam int id, @RequestBody Estudiante estudiante) {
        if (estudiante.getId()<= 0
                || estudiante.getNombre()==null
                || estudiante.getNombre().isEmpty()
                || estudiante.getApellido()==null
                || estudiante.getApellido().isEmpty()) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Información inválida, por favor corregir.");
        } else {
            Estudiante e = servicioEstudiante.actualizarEstudiante(id, estudiante);
            if (e == null) {
                return new ResponseEntity("Estudiante no encontrado o no fue posible actualizarlo; revise los datos ingresados.", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.status(HttpStatus.OK).body(e);
        }
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Estudiante> eliminarEstudiante (@PathVariable int id) {
        try {
            Estudiante e = servicioEstudiante.eliminarEstudiante(id);
            if (e == null) {
                return new ResponseEntity("Estudiante no encontrado.", HttpStatus.NOT_FOUND);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(e);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (path = "/listar")
    public ResponseEntity<List<Estudiante>> listarUsuarios () {
        return ResponseEntity.status(HttpStatus.OK).body(servicioEstudiante.listarEstudiantes());
    }

}