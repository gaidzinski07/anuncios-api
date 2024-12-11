package com.br.uff.anuncios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUsuarioDTO {

  private String email;
  private String senha;
}
