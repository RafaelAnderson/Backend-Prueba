package com.prueba.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_entidad")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11, nullable = false)
    private int id_entidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private TipoDocumento tipoDocumento;

    @Column(length = 25, nullable = false, unique = true)
    private String nro_documento;

    @Column(length = 100, nullable = false)
    private String razon_social;

    @Column(length = 100)
    private String nombre_comercial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_contribuyente", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private TipoContribuyente tipoContribuyente;

    @Column(length = 250)
    private String direccion;

    @Column(length = 50)
    private String telefono;

    @Column(nullable = false)
    private boolean estado;
}
