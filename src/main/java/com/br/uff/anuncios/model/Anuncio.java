package com.br.uff.anuncios.model;

import com.br.uff.anuncios.model.enums.Categoria;
import com.br.uff.anuncios.model.enums.TipoAnuncio;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name="anuncio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;
    @Lob
    private byte[] foto;
    @Column(precision = 10, scale = 2)
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_anuncio", nullable = false)
    private TipoAnuncio tipoAnuncio;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false)
    private Categoria categoria;

    @Column(nullable = false, length = 255)
    private String endereco;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Override
    public String toString() {
        return "Anuncio{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", foto=" + Arrays.toString(foto) +
                ", preco=" + preco +
                ", tipoAnuncio=" + tipoAnuncio +
                ", categoria=" + categoria +
                ", endereco='" + endereco + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
