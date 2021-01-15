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
public class FichaProduccion extends Model {
 //private int id;
 private int cantidad;
 private String fecha;
 private String tipopan;
 private int id_produccion;
 private int id_insumo;
 
  public FichaProduccion(){     
  }

 
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipopan() {
        return tipopan;
    }

    public void setTipopan(String tipopan) {
        this.tipopan = tipopan;
    }

    public int getId_produccion() {
        return id_produccion;
    }
    public void setId_produccion(int id_produccion) {
        this.id_produccion = id_produccion;
    }
    public int getId_insumo() {
        return id_insumo;
    }
    public void setId_insumo(int id_insumo) {
        this.id_insumo = id_insumo;
    }
  
 
     
}
