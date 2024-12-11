package com.br.uff.anuncios.dto;

import com.br.uff.anuncios.model.Anuncio;
import com.br.uff.anuncios.model.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnuncioDTO {

    private Long id;
    private String descricao;
    private String tipoAnuncio;
    private Double preco;
    private String endereco;
    private String categoria;
    private Long idUsuario;


    public Anuncio convertToEntity(){
        Anuncio anuncio = new Anuncio();
        anuncio.setTipoAnuncio(tipoAnuncio);
        anuncio.setId(id);
        anuncio.setDescricao(descricao);
        anuncio.setPreco(preco);
        anuncio.setCategoria(categoria);
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
        anuncio.setUsuario(usuario);
        anuncio.setEndereco(endereco);
        return anuncio;
    }


}
