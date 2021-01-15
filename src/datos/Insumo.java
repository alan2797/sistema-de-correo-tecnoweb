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
public class Insumo  extends Model {
    private String nombre;
    private int cantidadinsumo;
    private String fecha_compra;
    private float precio;
    private int id_proveedor;
    
    public Insumo(){
        
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadinsumo() {
        return cantidadinsumo;
    }

    public void setCantidadinsumo(int cantidadinsumo) {
        this.cantidadinsumo = cantidadinsumo;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
     public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
}
