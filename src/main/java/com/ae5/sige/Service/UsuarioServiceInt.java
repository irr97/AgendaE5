package com.ae5.sige.Service;

import java.util.List;

import com.ae5.sige.model.Usuario;

public interface UsuarioServiceInt {
	  /**
	   * @author ae5
	   */
	  List<Usuario> findAll();

	  /**
	   * @author ae5
	   */
	  Usuario findByUserDni(String dni);

	  /**
	   * @author ae5
	   */
	  void saveUsuario(Usuario usuario);

	  /**
	   * @author ae5
	   */
	  void updateUsuario(Usuario usuario);

	  /**
	   * @author ae5
	   */
	  void deleteUsuario(String dni);

	  /**
	   * @author ae5
	   */
	  Usuario getUserByDniAndPassword(String dni, String password);

}
