package com.ae5.sige.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.ae5.sige.model.Usuario;

@Repository
public class UsuarioRepository implements UsuarioRepositoryInt{
	 /**
	   * Instancia de la interfaz MongoOperations.
	   * 
	   * @author ae5
	   */
	  private final MongoOperations mongoOperations;

	  /**
	   * Constructor de la clase.
	   * 
	   * @author ae5
	   */
	  @Autowired

	  public UsuarioRepository(final MongoOperations mongoOperations) {
	    Assert.notNull(mongoOperations, "notNull");
	    this.mongoOperations = mongoOperations;

	  }

	  /**
	   * Devuelve todos los usuarios.
	   * 
	   * @author ae5
	   */
	  public Optional<List<Usuario>> findAll() {

	    List<Usuario> users = this.mongoOperations.find(new Query(), Usuario.class);

	    Optional<List<Usuario>> optionalUsuarios = Optional.ofNullable(users);

	    return optionalUsuarios;

	  }

	  /**
	   * Devuelve un usuario en función de su dni.
	   * 
	   * @author ae5
	   */
	  public Optional<Usuario> findOne(final String dni) {
	    System.out.println("el  usuario buscado  es: " + dni);
	    Usuario d = this.mongoOperations.findOne(new Query(Criteria.where("dni").is(dni)), Usuario.class);
	    Optional<Usuario> usuario = Optional.ofNullable(d);
	    return usuario;
	  }

	  /**
	   * Guarda un usuario en la base de datos.
	   * 
	   * @author ae5
	   */
	  public void saveUsuario(final Usuario usuario) {
	    this.mongoOperations.save(usuario);
	  }

	  /**
	   * Actualiza un usuario en la base de datos.
	   * 
	   * @author ae5
	   */
	  public void updateUsuario(final Usuario usuario) {

	    this.mongoOperations.save(usuario);

	  }

	  /**
	   * Borra un usuario en la base de datos.
	   * 
	   * @author ae5
	   */
	  public void deleteUsuario(final String dni) {

	    this.mongoOperations.findAndRemove(new Query(Criteria.where("dni").is(dni)), Usuario.class);

	  }

	@Override
	public Usuario findBynDniAndContrasena(String dni, String contrasena) {
		Usuario usuario = this.mongoOperations.findOne(new Query(Criteria.where("dni").is(dni).and("contrasena").is(contrasena)), Usuario.class);
		    return usuario;
	}

}
