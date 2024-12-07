package com.br.uff.anuncios.resource;

import com.br.uff.anuncios.dto.AnuncioRecordDTO;
import com.br.uff.anuncios.model.Anuncio;
import com.br.uff.anuncios.service.AnuncioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/anuncio")
public class AnuncioResource {

    @Autowired
    private AnuncioService anuncioService;

    @PostMapping("/criar")
    public ResponseEntity createChat(@RequestBody @Valid AnuncioRecordDTO anuncioRecordDTO) throws Exception {

        Anuncio anuncio = new Anuncio();
        BeanUtils.copyProperties(anuncioRecordDTO, anuncio);
        return ResponseEntity.status(HttpStatus.CREATED).body(anuncioService.save(anuncio));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Anuncio> getById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(anuncioService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
        anuncioService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Anuncio>> getAllAnuncio() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(anuncioService.findAll());
    }

    @PostMapping("/update")
    public ResponseEntity updateAnuncio(@RequestBody @Valid AnuncioRecordDTO anuncioRecordDTO) throws Exception {
        Anuncio anuncio = new Anuncio();
        BeanUtils.copyProperties(anuncioRecordDTO, anuncio);
        return ResponseEntity.status(HttpStatus.CREATED).body(anuncioService.update(anuncio));

    }


}
