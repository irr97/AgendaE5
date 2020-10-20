package com.ae5.sige.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ae5.sige.model.Usuario;
import com.ae5.sige.repository.UsuarioRepositoryInt;


@Service("UsuarioServiceInt")
/**
 * @author ae5
 */
@Transactional

public class UsuarioService implements UsuarioServiceInt {
  /**
   * @author ae5
   */
  private UsuarioRepositoryInt userRepository;

  /**
   * @author ae5
   */
  @Autowired

  public UsuarioService(final UsuarioRepositoryInt userRepository) {

    this.userRepository = userRepository;

  }

  /**
   * @author ae5
   */
  public Usuario findByUsernusuario(final String nusuario) {

    final Optional<Usuario> user = userRepository.findOne(nusuario);
	return user;
    


  }

  /**
   * @author ae5
   */
  public Optional<List<Usuario>> findAll() {

    final Optional<List<Usuario>> users = userRepository.findAll();

    return users;

  }

  /**
   * @author ae5
   */
  public void saveUsuario(final Usuario usuario) {

    userRepository.saveUsuario(usuario);

  } 

  /**
   * @author ae5
   */
  public void updateUsuario(final Usuario user) {

    userRepository.updateUsuario(user);

  }

  /**
   * @author ae5
   */
  public void deleteUsuario(final String userId) {

    userRepository.deleteUsuario(userId);

  }

  @Override
  public Usuario getUserBynusuarioAndPassword(final String nusuario, final String password) {

    final Usuario usuario = userRepository.findByDniAndContrasena(nusuario, password);
    return usuario;
  }

}
