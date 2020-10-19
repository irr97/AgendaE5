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
 * @author e3corp
 */
@Transactional

public class UsuarioService implements UsuarioServiceInt {
  /**
   * @author e3corp
   */
  private static final Log log = LogFactory.getLog(UsuarioService.class);
  /**
   * @author e3corp
   */
  private UsuarioRepositoryInt userRepository;

  /**
   * @author e3corp
   */
  @Autowired

  public UsuarioService(final UsuarioRepositoryInt userRepository) {

    this.userRepository = userRepository;

  }

  /**
   * @author e3corp
   */
  public Usuario findByUserDni(final String userDni) {

    final Optional<Usuario> user = userRepository.findOne(userDni);

    if (user.isPresent()) {

      log.debug(String.format("Read userId '{}'", userDni));

      final Optional<Usuario> userDesencriptado = Utilidades.desencriptarOptionalUsuario(user);

      return userDesencriptado.get();

    } else {

      throw new UserNotFoundException(userDni);

    }

  }

  /**
   * @author e3corp
   */
  public List<Usuario> findAll() {

    final Optional<List<Usuario>> users = userRepository.findAll();

    final List<Usuario> usersDesencrip = Utilidades.desencriptarListaUsuarios(users);

    return usersDesencrip;

  }

  /**
   * @author e3corp
   */
  public void saveUsuario(final Usuario usuario) {

    userRepository.saveUsuario(usuario);

  }

  /**
   * @author e3corp
   */
  public void updateUsuario(final Usuario user) {

    userRepository.updateUsuario(user);

  }

  /**
   * @author e3corp
   */
  public void deleteUsuario(final String userId) {

    userRepository.deleteUsuario(userId);

  }

  @Override
  public Usuario getUserByDniAndPassword(final String dni, final String password) {
    // System.out.println("[SERVER] DNI recibido: " + dni);
    // System.out.println("[SERVER] Contraseña recibida: " + password);

    final Usuario usuario = userRepository.findByDniAndContrasena(dni, password);
    final Usuario usuarioDesencriptado = Utilidades.desencriptarUsuario(usuario);
    return usuarioDesencriptado;
  }

}
