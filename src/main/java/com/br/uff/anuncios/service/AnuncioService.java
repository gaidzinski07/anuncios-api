package com.br.uff.anuncios.service;

import com.br.uff.anuncios.dto.AnuncioRecordDTO;
import com.br.uff.anuncios.model.Anuncio;
import com.br.uff.anuncios.repository.AnuncioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AnuncioService {

    private AnuncioRepository anuncioRepository;

    @Transactional
    public Anuncio save(Anuncio anuncio) throws Exception {
        try {
            return anuncioRepository.save(anuncio);
        } catch (Exception e) {
            throw new Exception("Erro ao salvar o anúncio: " + e.getMessage());
        }
    }

    @Transactional
    public Anuncio findById(Long id) {
        return anuncioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Anúncio com ID " + id + " não encontrado"));

    }

    @Transactional
    public void delete(Long id) {
        Anuncio anuncio = this.findById(id);
        anuncioRepository.delete(anuncio);

    }

    @Transactional
    public List<Anuncio> findAll() throws Exception {
        try {
            return anuncioRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Erro ao buscar todos os anuncio: " + e.getMessage());
        }

    }

    @Transactional
    public Anuncio update(Anuncio anuncio) throws Exception {
            return anuncioRepository.findById(anuncio.getId()).map(
                    anuncioFind -> {
                        anuncioFind.setTipoAnuncio(anuncio.getTipoAnuncio());
                        anuncioFind.setDescricao(anuncio.getDescricao());
                        anuncioFind.setCategoria(anuncio.getCategoria());
                        anuncioFind.setEndereco(anuncio.getEndereco());
                        anuncioFind.setPreco(anuncio.getPreco());
                        anuncioRepository.save(anuncioFind);
                        return anuncioFind;
                    }
            ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anuncio nãoo encontrado"));

    }



}
