package com.br.uff.anuncios.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String telefone;

    @Transient
    private Integer reputacao;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Anuncio> anuncios;
}
