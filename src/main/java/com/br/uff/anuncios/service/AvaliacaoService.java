package com.br.uff.anuncios.service;

import com.br.uff.anuncios.model.Avaliacao;
import com.br.uff.anuncios.repository.AvaliacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;

import java.util.Optional;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;
    @Autowired
    public AvaliacaoService(AvaliacaoRepository repository){ this.repository = repository;}

    @Transactional
    public Avaliacao findById(Long id){
        Optional<Avaliacao> optAvaliacao = repository.findById(id);
        System.out.println("optAvaliacao: " + optAvaliacao);
        return optAvaliacao.orElse(null);
    }

    @Transactional
    public Double getAverageByUserId(Long idUsuarioAvaliado) {
        Double average = repository.findAverageByUserId(idUsuarioAvaliado);
        if (average == null) {
            return null; // Retorna null se não houver avaliações
        }
        // Limita a 1 casa decimal
        DecimalFormat df = new DecimalFormat("#.0");
        return Double.valueOf(df.format(average).replace(",", "."));
    }
}
