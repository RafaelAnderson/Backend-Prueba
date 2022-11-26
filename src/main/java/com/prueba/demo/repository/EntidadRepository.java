package com.prueba.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.demo.model.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Integer> {

}
