package com.br.uff.anuncios.resource;

import com.br.uff.anuncios.dto.UsuarioRecordDTO;
import com.br.uff.anuncios.model.Usuario;
import com.br.uff.anuncios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> createChat(@RequestBody @Valid UsuarioRecordDTO usuario){
        Usuario u = new Usuario();
        BeanUtils.copyProperties(usuario, u);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(u));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

}
