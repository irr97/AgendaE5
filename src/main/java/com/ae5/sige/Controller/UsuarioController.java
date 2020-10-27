package com.ae5.sige.Controller;

import java.util.ArrayList;

import com.ae5.sige.model.Usuario;
import com.wordnik.swagger.annotations.ApiOperation;
import com.ae5.sige.Service.UsuarioService;
import com.ae5.sige.exception.UserNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

@RestController
@RequestMapping("/Usuarios")
@CrossOrigin()
public class UsuarioController {

	private static final Log LOG = LogFactory.getLog(UsuarioController.class);
	private final UsuarioService usuarioService;
	// private final UsuarioRepository usuarioRepository;

	@Autowired
	/**
	 * @author ae5
	 */
	public UsuarioController(final UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * Obtiene la contraseña del usuario mediante su dni.
	 * 
	 * @author ae5
	 */

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Usuario> getUserPassword(@RequestParam("dni") final String dni,
			@RequestParam("password") final String pass) {

		final Usuario usuario = usuarioService.getUserByDniAndPassword(dni, pass);
		if (usuario != null) {
			LOG.info("[SERVER] Usuario encontrado: " + usuario.getNombre());
			return ResponseEntity.ok(usuario);
		} else {
			LOG.info("[SERVER] No se ha encontrado ningún usuario con esos datos.");
			return ResponseEntity.badRequest().build();
		}
	}

	/**
	 * Obtiene un usuario mediante su dni.
	 * 
	 * @author ae5
	 */
	@RequestMapping(value = "/{userDni}", method = RequestMethod.GET)
	// @ApiOperation(value = "Find an user", notes = "Return a user by DNI")

	public ResponseEntity<Usuario> userByDni(@PathVariable final String dni) throws UserNotFound {
		LOG.info("[SERVER] Buscando usuario: " + dni);
		Usuario user;
		try {
			user = usuarioService.findByUserDni(dni);
			LOG.info("[SERVER] Usuario encontrado.");
		} catch (UserNotFound u) {
			user = null;
			LOG.error("[SERVER] Usuario no encontrado.");
		}
		return ResponseEntity.ok(user);
	}

	/**
	 * Registramos un usuario y guardamos ese usuario en la base de datos.
	 * 
	 * @author ae5.
	 */
	@RequestMapping(method = RequestMethod.POST)

	public ResponseEntity<Usuario> registrarUsuario(@RequestBody final String usuario) {
		final JSONObject jso = new JSONObject(usuario);
		final String dni = jso.getString("dni");
		final String contrasena = jso.getString("password");

		Usuario usuario1 = usuarioService.getUserByDniAndPassword(dni, contrasena);
		if (usuario1 == null) {
			String nombre = null;
			String apellidos = null;
			String correo = null;
			String telefono = null;
			String tipo = null;
			ArrayList<Object> ListaReuniones = null;
			ArrayList<Object> ListaReunionesNuevas = null;
			try {
				LOG.info("[SERVER] Registrando usuario...");
				nombre = jso.getString("nombre");
				apellidos = jso.getString("apellidos");
				telefono = jso.getString("tel");
				correo = jso.getString("correo");
				tipo = jso.getString("tipo");
			} catch (JSONException j) {
				LOG.info("[SERVER] Error en la lectura del JSON.");
				LOG.info(j.getMessage());
				return ResponseEntity.badRequest().build();
			}

			usuario1 = new Usuario(contrasena, nombre, apellidos, dni, telefono, correo, tipo, ListaReuniones,
					ListaReunionesNuevas);
			usuarioService.saveUsuario(usuario1);
			LOG.info("[SERVER] Usuario registrado.");
			LOG.info("[SERVER] " + usuario1.toString());
			return ResponseEntity.ok().build();
		} else {
			LOG.info("[SERVER] Error: El usuario ya está registrado.");
			LOG.info("[SERVER] " + usuario1.toString());
			return ResponseEntity.badRequest().build();
		}
	}

	/**
	 * Borra un usuario en funcion de su id.
	 * 
	 * @author ae5
	 */
	@RequestMapping(value = "/{dni}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete an user", notes = "Delete a user by dni")

	public ResponseEntity<Void> deleteUser(@PathVariable final String dni) {
		LOG.info("Delete user " + dni);
		usuarioService.deleteUsuario(dni);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{dni}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update usuario", notes = "Finds a dni and updates its fields")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody final String mensajerecibido,
			@PathVariable final String dni) {
		final JSONObject jso = new JSONObject(mensajerecibido);
		final Usuario usuario = usuarioService.findByUserDni(dni);
		if (usuario == null) {
			LOG.info("[SERVER] Error: el usuario no existe.");
			return ResponseEntity.badRequest().build();
		} else {
			try {
				LOG.info("[SERVER] Actualizando usuario...");

				// Depende de los campos que queramos que puedan actualizarse
				final String nombre = jso.getString("nombre");
				final String apellidos = jso.getString("apellidos");
				final String telefono = jso.getString("numTelefono");
				final String correo = jso.getString("correo");
				final String contrasena = jso.getString("contrasena");

				usuario.setDNI(dni);
				usuario.setNombre(nombre);
				usuario.setApellidos(apellidos);
				usuario.setTelefono(telefono);
				usuario.setCorreo(correo);
				usuario.setContrasena(contrasena);
			} catch (JSONException j) {
				LOG.error("[SERVER] Error en la lectura del JSON.");
				LOG.info(j.getMessage());
				return ResponseEntity.badRequest().build();
			}

			usuarioService.updateUsuario(usuario);
			LOG.info("[SERVER] Usuario actualizada.");
			LOG.info("[SERVER] " + usuario.toString());
			return ResponseEntity.ok().build();
		}
	}

	/*
	 * @GetMapping("/Usuarios") public List<Usuarios> findAll(){ return
	 * usuarioRepository.findAll(); }
	 * 
	 * 
	 * @PostMapping("/Usuarios") public Usuarios save(@RequestBody Usuarios
	 * usuario){ return usuarioRepository.save(usuario); }
	 * 
	 * @GetMapping("/Usuarios/{DNI}") public Usuarios find(@PathVariable("DNI")
	 * String DNI){ return usuarioRepository.findByDNI(DNI);
	 * 
	 * }
	 * 
	 * @RequestMapping(method = RequestMethod.GET)
	 * 
	 * public ResponseEntity<Usuarios> getUserPassword(@RequestParam("Usuario")
	 * final String Usuario,
	 * 
	 * @RequestParam("contrasena") final String Contrasena) {
	 * 
	 * final Usuarios usuario = usuarioService.getUserByDniAndPassword(Usuario,
	 * Contrasena); if (usuario != null) { LOG.info("[SERVER] Usuario encontrado: "
	 * + usuario.getNombre()); return ResponseEntity.ok(usuario); } else {
	 * LOG.info("[SERVER] No se ha encontrado ningún usuario con esos datos.");
	 * return ResponseEntity.badRequest().build(); } }
	 * 
	 */
}
