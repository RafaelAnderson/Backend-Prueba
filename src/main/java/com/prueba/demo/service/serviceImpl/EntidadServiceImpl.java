package com.prueba.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.demo.model.Entidad;
import com.prueba.demo.repository.EntidadRepository;
import com.prueba.demo.service.EntidadService;

@Service
public class EntidadServiceImpl implements EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    @Override
    public List<Entidad> listAll() {
        return entidadRepository.findAll();
    }

    @Override
    public Entidad getEntidad(int id) {
        return entidadRepository.findById(id).orElse(null);
    }

    @Override
    public Entidad createEntidad(Entidad entidad) {
        Entidad entidad_obj = entidadRepository.findById(entidad.getId_entidad()).orElse(null);

        if (entidad_obj != null) {
            return entidad_obj;
        }

        entidad_obj = entidadRepository.save(entidad);
        return entidad_obj;
    }

    @Override
    public Entidad updateEntidad(Entidad entidad) {
        Entidad entidad_obj = this.getEntidad(entidad.getId_entidad());

        if (entidad_obj == null) {
            return null;
        }

        entidad_obj.setDireccion(entidad.getDireccion());
        entidad_obj.setEstado(entidad.isEstado());
        entidad_obj.setNombre_comercial(entidad.getNombre_comercial());
        entidad_obj.setRazon_social(entidad.getRazon_social());
        entidad_obj.setTelefono(entidad.getTelefono());

        return entidadRepository.save(entidad_obj);
    }

    @Override
    public void deleteEntidad(int id) {
        Entidad entidad_obj = this.getEntidad(id);

        if (entidad_obj != null) {
            entidadRepository.delete(entidad_obj);
        }
    }
}
