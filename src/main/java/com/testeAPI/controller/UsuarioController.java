package com.testeAPI.controller;

import com.testeAPI.dto.UsuarioRequestDTO;
import com.testeAPI.model.Usuario;
import com.testeAPI.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService=usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioPorID(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioPorID(id);
        if(usuario==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@Valid  @RequestBody UsuarioRequestDTO dto) {
        Usuario usuario = usuarioService.postUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> putUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuarioDTO) {
        Usuario usuarioAtualizado = usuarioService.putUsuario(id, usuarioDTO);
        if(usuarioAtualizado==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> patchUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuarioDTO) {
        Usuario usuario = usuarioService.patchUsuario(id, usuarioDTO);
        if(usuario==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        boolean deletado = usuarioService.deleteUsuario(id);
        if(!deletado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
