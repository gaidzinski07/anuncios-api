package com.br.uff.anuncios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="anuncio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Anuncio  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


}
