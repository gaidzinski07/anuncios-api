package com.br.uff.anuncios.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "anuncio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Anuncio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private Double preco;

    @Column
    private String endereco;

    @Column
    private String categoria;

    @Column
    private String tipoAnuncio;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
