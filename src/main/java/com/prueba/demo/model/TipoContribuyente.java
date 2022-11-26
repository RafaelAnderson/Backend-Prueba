package com.prueba.demo.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_tipo_contribuyente")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoContribuyente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11, name = "id_tipo_contribuyente", nullable = false)
    private int id_tipo_contribuyente;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private boolean estado;

    @OneToMany
    @JoinColumn(name = "id_tipo_contribuyente")
    @JsonIgnore
    private List<Entidad> entidads;
}
