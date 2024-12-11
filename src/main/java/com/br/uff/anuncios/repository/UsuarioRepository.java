package com.br.uff.anuncios.repository;

import com.br.uff.anuncios.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Optional <Usuario> findByEmail(String email);
}
