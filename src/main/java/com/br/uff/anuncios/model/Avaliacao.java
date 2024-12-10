package com.br.uff.anuncios.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="avaliacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer avaliacao; // Valor entre 1 e 5
    @Column
    private Long id_usuario_avaliado;
    @Column
    private Long id_usuario_avaliador;
    @Column
    private Long id_anuncio;

}
