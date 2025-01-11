package com.br.uff.anuncios.repository;

import com.br.uff.anuncios.dto.AnuncioDTO;
import com.br.uff.anuncios.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    @Query(value="select a from Anuncio a where a.descricao like %?1%")
    ArrayList<Anuncio> buscaSimples(String titulo);

}
