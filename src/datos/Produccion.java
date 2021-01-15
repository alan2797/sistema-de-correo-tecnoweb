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
public class Produccion extends Model {
       private String  fecha_produccion;
    private String  estado;
    private String tipo;
    private int  id_empleado;
     
   
   public Produccion(){
       
   }

    public String getFecha_produccion() {
        return fecha_produccion;
    }

    public void setFecha_produccion(String fecha_produccion) {
        this.fecha_produccion = fecha_produccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    // private Integer id;
    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
 

    
}
