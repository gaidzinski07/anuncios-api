package com.br.uff.anuncios.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.br.uff.anuncios.model.Usuario;
import com.br.uff.anuncios.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
  
  @InjectMocks
  private UsuarioService usuarioService;

  @Mock
  private UsuarioRepository usuarioRepository;

  @Test
  @DisplayName("Deve ser capaz de encontrar usuário por id")
    public void should_be_able_to_find_user_by_id() {
      var usuario = new Usuario();
      usuario.setId(1L);

      when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

      usuarioService.findById(1L);
   }

   @Test
    @DisplayName("Deve ser capaz de criar um novo usuário")
    public void should_be_able_to_create_a_new_user() {
      var usuario = new Usuario();
      usuario.setId(1L);
      usuario.setNome("João");
      usuario.setEmail("joao@id.uff.br");
      usuario.setSenha("123456");
      usuario.setTelefone("21999999999");
      
      when(usuarioRepository.save(usuario)).thenReturn(usuario);

      var result = usuarioService.save(usuario);

      assertEquals(usuario, result);
    }

    @Test
    @DisplayName("Deve ser capaz de lançar uma exceção ao tentar criar um usuário com um email inválido")
    public void should_be_able_to_throw_an_exception_when_trying_to_create_a_user_with_an_invalid_email() {
      var usuario = new Usuario();
      usuario.setId(1L);
      usuario.setNome("João");
      usuario.setEmail("joao@gmail.com");
      usuario.setSenha("123456");
      usuario.setTelefone("21999999999");

      try {
        usuarioService.save(usuario);
      } catch (IllegalArgumentException e) {
        assertEquals("O email informado deve estar num domínio da Universidade Federal Fluminense.", e.getMessage());
      }
    }
}
