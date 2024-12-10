package com.br.uff.anuncios.resource;

import com.br.uff.anuncios.dto.AuthUsuarioDTO;
import com.br.uff.anuncios.dto.UsuarioRecordDTO;
import com.br.uff.anuncios.model.Usuario;
import com.br.uff.anuncios.service.UsuarioService;
import jakarta.validation.Valid;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @PostMapping("/auth")
    public ResponseEntity<Object> authenticate(@RequestBody AuthUsuarioDTO authUsuarioDTO) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.authenticate(authUsuarioDTO));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity createChat(@RequestBody @Valid UsuarioRecordDTO usuario){
        try {
            Usuario u = new Usuario();
            BeanUtils.copyProperties(usuario, u);
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(u));
        }catch (IllegalArgumentException i){
            return ResponseEntity.status(HttpStatus.CREATED).body(i.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    
    

}
