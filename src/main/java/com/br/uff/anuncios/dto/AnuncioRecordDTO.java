package com.br.uff.anuncios.dto;

import com.br.uff.anuncios.model.enums.Categoria;
import com.br.uff.anuncios.model.enums.TipoAnuncio;

import java.math.BigDecimal;

public record AnuncioRecordDTO(
        Long id,
        String descricao,
        byte[] foto,
        TipoAnuncio tipoAnuncio,
        BigDecimal preco,
        String endereco,
        Categoria categoria,
        Long idUsuario
) {
}
