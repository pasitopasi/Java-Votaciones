/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.sql.Blob;

/**
 *
 * @author pasito
 */
public class Reloj {
    private String marca;
    private int votos;
    private int id;
    private String logo;
    
    public Reloj(String marca, int votos, String logo) {
        this.marca = marca;
        this.votos = votos;
        this.logo = logo;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getVotos() {
        return votos;
    }
    public void setVotos(int votos) {
        this.votos = votos;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Reloj: " + "marca= " + marca + ", votos= " + votos + ", logo= " + logo;
    }
}
