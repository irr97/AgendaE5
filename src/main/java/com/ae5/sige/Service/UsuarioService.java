package com.ae5.sige.Service;

import com.ae5.sige.Documents.Usuarios;
import com.ae5.sige.Repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;


    public Usuarios getUserByDniAndPassword(final String Usuario, final String Contrasena) {
      final Usuarios usuario = usuarioRepository.findByUsuarioAndContrasena(Usuario, Contrasena);
      return usuario;
    }
    
}
