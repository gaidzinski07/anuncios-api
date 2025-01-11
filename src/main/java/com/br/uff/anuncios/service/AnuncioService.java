package com.br.uff.anuncios.service;

import com.br.uff.anuncios.model.Anuncio;
import com.br.uff.anuncios.repository.AnuncioRepository;
import com.br.uff.anuncios.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AnuncioService {

    private final AnuncioRepository repository;

    public AnuncioService(AnuncioRepository repository){ this.repository = repository;}

    @Transactional
    public Anuncio save(Anuncio anuncio){
        return repository.save(anuncio);
    }

    public ArrayList<Anuncio> buscaSimples(String titulo) {

        return repository.buscaSimples(titulo);

    }
}
