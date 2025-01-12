package com.br.uff.anuncios.resource;

import com.br.uff.anuncios.dto.AnuncioDTO;
import com.br.uff.anuncios.model.Anuncio;
import com.br.uff.anuncios.model.Usuario;
import com.br.uff.anuncios.service.AnuncioService;
import com.br.uff.anuncios.service.UsuarioService;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/anuncio")
public class AnuncioResource {

    @Autowired
    private AnuncioService service;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criar")
    public ResponseEntity cadastrar(@RequestBody @NotNull Anuncio anuncio){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(anuncio));
    }

    @GetMapping("/buscar/{titulo}")
    public ResponseEntity buscaSimples(@PathVariable String titulo){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaSimples(titulo));
    }

}
