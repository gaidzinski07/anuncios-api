package com.br.uff.anuncios.service;

import com.br.uff.anuncios.model.Anuncio;
import com.br.uff.anuncios.model.Usuario;
import com.br.uff.anuncios.repository.AnuncioRepository;
import com.br.uff.anuncios.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnuncioService {

    private final AnuncioRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public AnuncioService(AnuncioRepository repository){ this.repository = repository;}

    @Transactional
    public Anuncio save(Anuncio anuncio){
        Usuario usuario = usuarioRepository.findById(anuncio.getUsuario().getId()).get();
        anuncio.setUsuario(usuario);

        return repository.save(anuncio);
    }

    public ArrayList<Anuncio> buscaSimples(String titulo) {

        return repository.buscaSimples(titulo);

    }

    public List<Anuncio> listar() {
        return repository.findAll();
    }

    @Transactional
    public Anuncio editar(Anuncio anuncio) {
        return repository.save(anuncio);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
