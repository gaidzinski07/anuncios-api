package com.br.uff.anuncios.resource;
import com.br.uff.anuncios.model.Avaliacao;
import com.br.uff.anuncios.service.AvaliacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/avaliacao")
public class AvaliacaoResource {
    @Autowired
    private AvaliacaoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping("/media/{idUsuarioAvaliado}")
    public ResponseEntity<Double> getAverageByUserId(@PathVariable Long idUsuarioAvaliado) {
        Double average = service.getAverageByUserId(idUsuarioAvaliado);
        return ResponseEntity.status(HttpStatus.OK).body(average);
    }
}
