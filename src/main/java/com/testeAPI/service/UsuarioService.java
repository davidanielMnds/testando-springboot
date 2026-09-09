package com.testeAPI.service;

import com.testeAPI.dto.UsuarioRequestDTO;
import com.testeAPI.model.Usuario;
import com.testeAPI.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios() {return usuarioRepository.pegarUsuarios();}

    public Usuario getUsuarioPorID(Long id) {return usuarioRepository.pegarUsuarioPorID(id);}

    public Usuario postUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioRepository.incrementarID());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuarioRepository.salvarUsuario(usuario);
        return usuario;
    }

    public Usuario putUsuario(Long id, UsuarioRequestDTO usuarioDTO) {
        Usuario usuarioAntigo = usuarioRepository.pegarUsuarioPorID(id);
        if(usuarioAntigo==null) {
            return null;
        }
        usuarioAntigo.setNome(usuarioDTO.getNome());
        usuarioAntigo.setEmail(usuarioDTO.getEmail());
        return usuarioAntigo;
    }

    public Usuario patchUsuario(Long id, UsuarioRequestDTO usuarioDTO) {
        Usuario usuarioAntigo = usuarioRepository.pegarUsuarioPorID(id);
        if(usuarioAntigo==null) {return null;}

        if(usuarioDTO.getNome()!=null) {
            usuarioAntigo.setNome(usuarioDTO.getNome());
        }
        if(usuarioDTO.getEmail()!=null) {
            usuarioAntigo.setEmail(usuarioDTO.getEmail());
        }
        return usuarioAntigo;
    }

    public boolean deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.pegarUsuarioPorID(id);
        if(usuario==null) {return false;}
        usuarioRepository.deletarUsuario(usuario);
        return true;
    }
}
