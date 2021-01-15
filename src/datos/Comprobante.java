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
public class Comprobante extends Model{
 private String fecha_compra;
 private String estado;
 private int id_cliente;
 private int id_empleado;
        
         public Comprobante(){
       
          }


    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_clientes(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }    
}
