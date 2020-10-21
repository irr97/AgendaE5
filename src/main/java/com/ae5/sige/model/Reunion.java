package com.ae5.sige.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Reuniones")
public class Reunion {
		  /**
		   * ID.
		   * 
		   * @author ae5
		   */
		  @Id
		  private String id;
		  
		  /**
		   * Titulo.
		   * 
		   * @author ae5
		   */
		 
		  private String titulo;
		  
		  /**
		   * Descripcion.
		   * 
		   * @author ae5
		   */
		 
		  private String descripcion;
		  /**
		   * Organizador.
		   * 
		   * @author ae5
		   */
		 
		  private String organizador;
		  /**
		   * Fecha.
		   * 
		   * @author ae5
		   */
		 
		  private String fecha;
		  /**
		   * Hora.
		   * 
		   * @author ae5
		   */
		 
		  private String hora;
		  /**
		   * ListaAsistentes.
		   * 
		   * @author ae5
		   */
		 
		  private ArrayList<String> listaAsistentes = new ArrayList<>();
		
		public Reunion(String id, String titulo, String descripcion, String organizador, String fecha, String hora,
				ArrayList<String> listaAsistentes) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.descripcion = descripcion;
			this.organizador = organizador;
			this.fecha = fecha;
			this.hora = hora;
			this.listaAsistentes = listaAsistentes;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getOrganizador() {
			return organizador;
		}
		public void setOrganizador(String organizador) {
			this.organizador = organizador;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getHora() {
			return hora;
		}
		public void setHora(String hora) {
			this.hora = hora;
		}
		public ArrayList<String> getListaAsistentes() {
			return listaAsistentes;
		}
		public void setListaAsistentes(ArrayList<String> listaAsistentes) {
			this.listaAsistentes = listaAsistentes;
		}
		@Override
		public String toString() {
			return "Reunion [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", organizador="
					+ organizador + ", fecha=" + fecha + ", hora=" + hora + ", ListaAsistentes=" + listaAsistentes
					+ "]";
		}
		  
		  
		  
		  
}
