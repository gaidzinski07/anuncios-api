package com.br.uff.anuncios.repository;

import com.br.uff.anuncios.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    @Query("SELECT AVG(a.avaliacao) FROM Avaliacao a WHERE a.id_usuario_avaliado = :idUsuarioAvaliado")
    Double findAverageByUserId(@Param("idUsuarioAvaliado") Long idUsuarioAvaliado);
}


