package com.ae5.sige.model;



import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Usuarios")
public class Usuario {
	  /**
	   * ID.
	   * 
	   * @author e3corp
	   */
	  @Id
	  private String id;
	  /**
	   * nUsuario.
	   * 
	   * @author e3corp
	   */
	  private String nUsuario;
	  /**
	   * Contraseña.
	   * 
	   * @author e3corp
	   */
	  private String Contraseña;
	  /**
	   * Nombre.
	   * 
	   * @author e3corp
	   */
	  private String Nombre;
	  /**
	   * Apellidos.
	   * 
	   * @author e3corp
	   */
	  private String Apellidos;
	  /**
	   * DNI.
	   * 
	   * @author e3corp
	   */
	  private String DNI;
	  /**
	   * Telefono.
	   * 
	   * @author e3corp
	   */
	  private String Telefono;
	  /**
	   * Correo.
	   * 
	   * @author e3corp
	   */
	  private String Correo;
	  /**
	   * Tipo.
	   * 
	   * @author ae5
	   */
	  private String Tipo;
	  /**
	   * ListaReuniones.
	   * 
	   * @author ae5
	   */
	  private ArrayList<Object> ListaReuniones = new ArrayList<Object>();
	  /**
	   * ListaReunionesNuevas.
	   * 
	   * @author ae5
	   */
	  private ArrayList<Object> ListaReunionesNuevas = new ArrayList<Object>();
	  
	public Usuario(String id, String nusuario, String contraseña, String nombre, String apellidos, String dNI,
			String telefono, String correo, String tipo, ArrayList<Object> listaReuniones,
			ArrayList<Object> listaReunionesNuevas) {
		super();
		this.id = id;
		nUsuario = nusuario;
		Contraseña = contraseña;
		Nombre = nombre;
		Apellidos = apellidos;
		DNI = dNI;
		Telefono = telefono;
		Correo = correo;
		Tipo = tipo;
		ListaReuniones = listaReuniones;
		ListaReunionesNuevas = listaReunionesNuevas;
	}

	public Usuario() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsuario() {
		return nUsuario;
	}

	public void setUsuario(String usuario) {
		nUsuario = usuario;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public ArrayList<Object> getListaReuniones() {
		return ListaReuniones;
	}

	public void setListaReuniones(ArrayList<Object> listaReuniones) {
		ListaReuniones = listaReuniones;
	}

	public ArrayList<Object> getListaReunionesNuevas() {
		return ListaReunionesNuevas;
	}

	public void setListaReunionesNuevas(ArrayList<Object> listaReunionesNuevas) {
		ListaReunionesNuevas = listaReunionesNuevas;
	}
	
	
	  
	  
}
