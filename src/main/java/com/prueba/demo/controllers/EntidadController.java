package com.prueba.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.prueba.demo.model.Entidad;
import com.prueba.demo.service.EntidadService;
import com.prueba.demo.util.Mensaje;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entidad")
public class EntidadController {

    @Autowired
    EntidadService entidadService;

    @GetMapping("/listar")
    public ResponseEntity<List<Entidad>> findAll() {

        List<Entidad> entidades = new ArrayList<>();
        entidades = entidadService.listAll();

        if (entidades.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(entidades);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Entidad> getEntidad(
            @PathVariable("id") int id) {
        Entidad entidad = entidadService.getEntidad(id);

        if (entidad == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(entidad);
    }

    @PostMapping("/crear")
    public ResponseEntity<Entidad> createEntidad(
            @RequestBody Entidad entidad, BindingResult result) {

        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Mensaje.formatMessage(result));
        }

        Entidad crearEntidad = entidadService.createEntidad(entidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(crearEntidad);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Entidad> updateEntidad(
            @PathVariable("id") int id,
            @RequestBody Entidad entidad) {
        entidad.setId_entidad(id);
        Entidad entidad_obj = entidadService.updateEntidad(entidad);

        if (entidad_obj == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(entidad_obj);
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteEntidad(@PathVariable("id") int id) {

        entidadService.deleteEntidad(id);
        return "Se eliminó la entidad" + id;
    }
}
