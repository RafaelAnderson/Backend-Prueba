package com.prueba.demo.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_tipo_documento")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoDocumento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11, nullable = false)
    private int id_tipo_documento;

    @Column(length = 20, nullable = false)
    private String codigo;
    
    @Column(length = 100, nullable = false)
    private String nombre;
    
    @Column(length = 200)
    private String descripcion;
    
    @Column(nullable = false)
    private boolean estado;

    @OneToMany
    @JoinColumn(name = "id_tipo_documento")
    @JsonIgnore
    private List<Entidad> entidads;
}
