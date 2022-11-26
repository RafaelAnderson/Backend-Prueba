package com.prueba.demo.service;

import java.util.List;

import com.prueba.demo.model.Entidad;

public interface EntidadService {

    List<Entidad> listAll();
    Entidad getEntidad(int id);
    Entidad createEntidad(Entidad entidad);
    Entidad updateEntidad(Entidad entidad);
    void deleteEntidad(int id);
}
