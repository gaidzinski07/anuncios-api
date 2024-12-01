package com.br.uff.anuncios.model;

import lombok.Data;

import java.util.List;

@Data
public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Integer reputacao;
    private List<String> historicoDeTrancacoes;

}
