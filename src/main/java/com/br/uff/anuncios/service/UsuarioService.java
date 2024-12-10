package com.br.uff.anuncios.service;

import com.br.uff.anuncios.model.Usuario;
import com.br.uff.anuncios.repository.UsuarioRepository;
import com.br.uff.anuncios.util.EmailUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    @Autowired
    public UsuarioService(UsuarioRepository repository){ this.repository = repository;}

    @Transactional
    public Usuario findById(Long id){
        Optional<Usuario> optUser = repository.findById(id);
        System.out.println("optUser: " + optUser);
        return optUser.orElse(null);
    }

    @Transactional
    public Usuario save(Usuario usuario) throws IllegalArgumentException{

        if(!EmailUtils.isEmailUff(usuario.getEmail())){
            throw new IllegalArgumentException("O email informado deve estar num domínio da Universidade Federal Fluminense.");
        }
        repository.save(usuario);
        return repository.save(usuario);

    }

}
