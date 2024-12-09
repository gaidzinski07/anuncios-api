package com.br.uff.anuncios.dto;

import jakarta.validation.constraints.NotNull;

public record UsuarioRecordDTO (@NotNull String nome, @NotNull String email, @NotNull String senha, String telefone,  String id) {
}
