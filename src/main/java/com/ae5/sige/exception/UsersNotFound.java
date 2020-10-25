package com.ae5.sige.exception;

import java.util.ArrayList;

import org.springframework.core.NestedRuntimeException;

public class UsersNotFound extends NestedRuntimeException {

	  private static final long serialVersionUID = 1L;

	  /**
	   * Este método muestra el mensaje de excepción de usuario no encontrado.
	   */
	  public UsersNotFound() {

	    super(String.format("No se ha podido encontrar ningun usuario"));

	  }

}
