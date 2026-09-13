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

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioPorID(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario postUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        return usuarioRepository.save(usuario);
    }

    public Usuario putUsuario(Long id, UsuarioRequestDTO usuarioDTO) {
        Usuario usuarioAntigo = usuarioRepository.findById(id).orElse(null);
        if(usuarioAntigo==null) {
            return null;
        }
        usuarioAntigo.setNome(usuarioDTO.getNome());
        usuarioAntigo.setEmail(usuarioDTO.getEmail());
        return usuarioRepository.save(usuarioAntigo);
    }

    public Usuario patchUsuario(Long id, UsuarioRequestDTO usuarioDTO) {
        Usuario usuarioAntigo = usuarioRepository.findById(id).orElse(null);
        if(usuarioAntigo==null) {return null;}

        if(usuarioDTO.getNome()!=null && !usuarioDTO.getNome().isBlank()) {
            usuarioAntigo.setNome(usuarioDTO.getNome());
        }
        if(usuarioDTO.getEmail() != null && !usuarioDTO.getEmail().isBlank()) {
            usuarioAntigo.setEmail(usuarioDTO.getEmail());
        }
        return usuarioRepository.save(usuarioAntigo);
    }

    public boolean deleteUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            return false;
        }
        usuarioRepository.deleteById(id);
        return true;
    }
}
