package com.ae5.sige.Documents;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuarios")
public class Usuarios {

    @Id
    private String id = new ObjectId().toString();

    private String Usuario;

    private String Contraseña;

    private String Nombre;

    private String DNI;

    private String Apellidos;

    private int Telefono;

    private String Tipo;

    private List<Reunion> ListaReuniones;

    private List<Reunion> ListaReunionesNuevas;

    public Usuarios() {
        // Constructor vacio para generar usuarios
    }

    public List<Reunion> getListaReunionesNuevas() {
        return ListaReunionesNuevas;
    }

    public void setListaReunionesNuevas(List<Reunion> listaReunionesNuevas) {
        this.ListaReunionesNuevas = listaReunionesNuevas;
    }

    public List<Reunion> getListaReuniones() {
        return ListaReuniones;
    }

    public void setListaReuniones(List<Reunion> listaReuniones) {
        this.ListaReuniones = listaReuniones;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        this.Telefono = telefono;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        this.DNI = dNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        this.Contraseña = contraseña;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUser(String usuario) {
        this.Usuario = usuario;
    }


    
    
}
