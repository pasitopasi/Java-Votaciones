/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author pasito
 */
public class Operaciones {

    public boolean IntroducirUsuario(Connection con, Usuario usuario) {
        String sql = "INSERT INTO votante values(null, ?, ?, ?, AES_ENCRYPT(?, 'semilla'), '')";
        PreparedStatement sentencia;
        try {
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, usuario.getDni());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(3, usuario.getApellido());
            sentencia.setString(4, usuario.getContrasena());

            if (sentencia.executeUpdate() != 1) {
                return false; //fila no insertada
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

    public String AccesoSistema(Connection con, Usuario usuario) {
        String sql = "SELECT * FROM votante WHERE DNI=? AND AES_DECRYPT(Contrasena, 'semilla')=?";
        PreparedStatement sentencia;
        try {
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, usuario.getDni());
            sentencia.setString(2, usuario.getContrasena());

            ResultSet resultado = sentencia.executeQuery();

            /**
             * Aqui vamos a comprobar si ha votado o no
             */
            while (resultado.next()) {
                String voto = resultado.getString("Voto");
                if (voto.equals("si")) {
                    return "ya ha votado.";
                } else {
                    return "si";
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return "el usuario no se ha encontrado.";
        }
        return "el usuario no esta registrado o te has equivocado de contrasena.";
    }

    public ArrayList<Reloj> ObtenerRelojes(Connection con) {
        ArrayList<Reloj> relojes = new ArrayList<>();

        String sql = "SELECT * FROM reloj";
        PreparedStatement sentencia;
        try {
            sentencia = con.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String marca = resultado.getString("Marca");
                int votos = resultado.getInt("Votos");
                byte[] imagen1 = resultado.getBytes("Icono");
                int id = resultado.getInt("ID");
                
                String imagen = Base64.getEncoder().encodeToString(imagen1);
                Reloj r = new Reloj(marca, votos, imagen);
                r.setId(id);
                relojes.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return relojes;
    }

    public void votarReloj(Connection con, Usuario usuario, String reloj) {
        try {
            con.setAutoCommit(false);
            /* registro el voto */
            votar(con, usuario);
            /* cuento el voto */
            sumarVoto(con, reloj);
            
            con.commit();
        } catch (SQLException ex) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex1) {
                    
                }
            }
        }
    }
    
    private boolean votar(Connection con, Usuario usuario) throws SQLException{
        String sql = "UPDATE votante set Voto=? where DNI=?";
        PreparedStatement sentencia;
        try {
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, "si");
            sentencia.setString(2, usuario.getDni());

            if (sentencia.executeUpdate() != 1) {
                throw new SQLException(); //fila no actualizada
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new SQLException(ex);
        }
        return true;
    }
    
    private boolean sumarVoto(Connection con, String reloj) throws SQLException{
        String sql = "UPDATE reloj set Votos=Votos+1 where ID=?";
        PreparedStatement sentencia;
        try {
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, reloj);

            if (sentencia.executeUpdate() != 1) {
                throw new SQLException(); //fila no actualizada
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new SQLException(ex);
        }
        return true;
    }
    
    public double escrutinio(Connection con){
        try {
            double x = Votantes(con);
            double y = VotantesSI(con);
            return y/x*100;
        } catch (SQLException ex) {
            return 1;
        }
    }
    
    private double Votantes(Connection con) throws SQLException{
        String sql = "SELECT * FROM votante";
        PreparedStatement sentencia;
        int votantes=0;
        try {
            sentencia = con.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next())
                votantes++;
            return votantes;
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    private double VotantesSI(Connection con) throws SQLException{
        String sql = "SELECT * FROM votante WHERE Voto='si'";
        PreparedStatement sentencia;
        int votantes=0;
        try {
            sentencia = con.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next())
                votantes++;
            return votantes;
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public ArrayList<Usuario> ObtenerVotantes(Connection con) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM votante ORDER BY DNI ASC";
        PreparedStatement sentencia;
        try {
            sentencia = con.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String dni = resultado.getString("DNI");
                String nombre = resultado.getString("Nombre");
                String apellido = resultado.getString("Apellido");
                String voto = resultado.getString("Voto");
                
                Usuario r = new Usuario(dni, nombre, apellido);
                r.setVoto(voto);
                
                usuarios.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return usuarios;
    }
    
    public boolean BorrarUsuario(Connection con, Usuario usuario) {
        String sql = "DELETE FROM votante WHERE DNI=?";
        PreparedStatement sentencia;
        try {
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, usuario.getDni());

            if (sentencia.executeUpdate() != 1) {
                return false; //fila no borrada
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }
    
    public Reloj obtenerReloj(Connection con, String id_reloj){
        Reloj reloj = null;

        String sql = "SELECT * FROM reloj WHERE ID=?";
        PreparedStatement sentencia;
        try {
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, id_reloj);
            
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String marca = resultado.getString("Marca");
                int votos = resultado.getInt("Votos");
                byte[] imagen1 = resultado.getBytes("Icono");
                
                String imagen = Base64.getEncoder().encodeToString(imagen1);
                reloj = new Reloj(marca, votos, imagen);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return reloj;
    }
}
