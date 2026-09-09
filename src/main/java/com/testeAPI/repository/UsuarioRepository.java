package com.testeAPI.repository;

import com.testeAPI.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {
    private Long idAtual = 0L;
    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> pegarUsuarios() {
        return usuarios;
    }

    public Usuario pegarUsuarioPorID(Long id) {
        for(Usuario u : usuarios) {
            if(u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void salvarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void deletarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public Long incrementarID() {
        idAtual++;
        return idAtual;
    }

}
