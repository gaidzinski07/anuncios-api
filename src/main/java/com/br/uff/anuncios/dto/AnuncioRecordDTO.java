package com.br.uff.anuncios.dto;

import java.math.BigDecimal;

public record AnuncioRecordDTO(
        Long id,
        String descricao,
        byte[] foto,
        String tipoAnuncio,
        BigDecimal preco,
        String endereco,
        String categoria,
        Long idUsuario
) {
}
