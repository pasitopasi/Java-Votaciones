/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author pasito
 */
public class Usuario {
    private String dni;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String voto;
    
    public Usuario(String dni, String nombre, String apellido, String contrasena) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
    }
    public Usuario(String dni, String contrasena) {
        this.dni = dni;
        this.contrasena = contrasena;
        this.nombre = null;
        this.apellido = null;
    }

    public Usuario(String dni_votante) {
        this.dni = dni_votante;
        this.contrasena = null;
        this.nombre = null;
        this.apellido = null;
    }
    
    public Usuario(String dni_votante, String nombre, String apellido) {
        this.dni = dni_votante;
        this.contrasena = null;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public String getVoto() {
        return voto;
    }
    public void setVoto(String voto) {
        this.voto = voto;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    @Override
    public String toString() {
        return "Usuario: " + "dni= " + dni + ", nombre= " + nombre + ", apellido= " + apellido + ", correo= " + contrasena;
    }
}
