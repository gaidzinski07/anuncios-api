package com.br.uff.anuncios.service;

import com.br.uff.anuncios.dto.AnuncioRecordDTO;
import com.br.uff.anuncios.model.Anuncio;
import com.br.uff.anuncios.model.Usuario;
import com.br.uff.anuncios.repository.AnuncioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Base64;
import java.util.List;
import java.util.Optional;



@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Anuncio save(AnuncioRecordDTO anuncioDTO) throws Exception {
        try {
            System.out.println("Salvando anúncio: " + anuncioDTO.toString());

            // Converte o DTO para a entidade Anuncio
            Anuncio anuncio = new Anuncio();
            anuncio.setId(anuncioDTO.id());
            anuncio.setDescricao(anuncioDTO.descricao());
            anuncio.setFoto(anuncio.getFoto());
            anuncio.setPreco(anuncioDTO.preco());
            anuncio.setTipoAnuncio(anuncioDTO.tipoAnuncio());
            anuncio.setCategoria(anuncioDTO.categoria());
            anuncio.setEndereco(anuncioDTO.endereco());

            // Aqui você recupera o usuário com o ID informado no DTO
            Usuario usuario = usuarioService.findById(anuncioDTO.usuario().getId());

            // Associa o usuário ao anúncio
            anuncio.setUsuario(usuario);

            // Salva o anúncio no banco de dados
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
    public Anuncio update(Anuncio anuncio) throws ResponseStatusException {
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
