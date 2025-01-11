package com.br.uff.anuncios.dto;

import com.br.uff.anuncios.model.Usuario;
import com.br.uff.anuncios.model.enums.Categoria;
import com.br.uff.anuncios.model.enums.TipoAnuncio;

import java.math.BigDecimal;

public record AnuncioRecordDTO(
        Long id,
        String descricao,
        byte[] foto,
        TipoAnuncio tipoAnuncio,
        Categoria categoria,
        BigDecimal preco,
        String endereco,
        Usuario usuario
) {
}
