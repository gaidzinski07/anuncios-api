package com.br.uff.anuncios.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.br.uff.anuncios.dto.AuthUsuarioDTO;
import com.br.uff.anuncios.model.Usuario;
import com.br.uff.anuncios.repository.UsuarioRepository;
import com.br.uff.anuncios.util.EmailUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

@Service
public class UsuarioService {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario findById(Long id){
        Optional<Usuario> optUser = this.usuarioRepository.findById(id);
        return optUser.orElse(null);
    }

    public Usuario findByEmail(String email){
        Optional<Usuario> optUser = this.usuarioRepository.findByEmail(email);
        return optUser.orElse(null);
    }

    @Transactional
    public Usuario save(Usuario usuario) throws IllegalArgumentException{

        if(!EmailUtils.isEmailUff(usuario.getEmail())){
            throw new IllegalArgumentException("O email informado deve estar num domínio da Universidade Federal Fluminense.");
        }

        var password = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(password);

        this.usuarioRepository.save(usuario);
        return this.usuarioRepository.save(usuario);

    }

    public String authenticate(AuthUsuarioDTO authUsuarioDTO) throws AuthenticationException {
        var usuario =this.usuarioRepository.findByEmail(authUsuarioDTO.getEmail()).orElseThrow(
            () -> {
                throw new Error("Usuário não encontrado");
            }
        );

        var senhaMatches = this.passwordEncoder.matches(authUsuarioDTO.getSenha(), usuario.getSenha());

        if(!senhaMatches){
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey); 
        var token = JWT.create().withIssuer("anuncios-api")
            .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
            .withSubject(usuario.getEmail())
            .sign(algorithm);

        return token;
    }

    @Transactional
    public Usuario update(Usuario usuario){
        Optional<Usuario> optUser = this.usuarioRepository.findById(usuario.getId());

        usuario.setSenha(optUser.get().getSenha());

        return this.usuarioRepository.save(usuario);
    }

}
