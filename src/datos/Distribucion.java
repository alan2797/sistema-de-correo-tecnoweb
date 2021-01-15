/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import persistencia.Model;

/**
 *
 * @author BLADIMIR
 */
public class Distribucion extends Model {
 //private int id;
 private String tipodistribucion;
 private String tipotransporte;
 private String descripcion;
 
 public Distribucion(){
    
}


    public String getTipodistribucion() {
        return tipodistribucion;
    }

    public void setTipodistribucion(String tipodistribucion) {
        this.tipodistribucion = tipodistribucion;
    }

    public String getTipotransporte() {
        return tipotransporte;
    }

    public void setTipotransporte(String tipotransporte) {
        this.tipotransporte = tipotransporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
