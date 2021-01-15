/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.Produccion;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BLADIMIR
 */
public class NProduccion implements INegocio<Produccion>{
    
      private Produccion produccion;

    public NProduccion() {
    }
    
    @Override
    public Produccion get(int id) {
    return Produccion.find(id, ()->new Produccion());
    }

    @Override
    public List<Produccion>getALL() {
    return Produccion.all(()->new Produccion());
    }

    @Override
    public int registrar(Map<String, Object> data) {
        produccion = new Produccion();
        setDatos(data);
        produccion.save();
        return 0;
    }

    @Override
    public void modificar(Map<String, Object> data) {
        produccion = Produccion.find((int)data.get("id"), ()->new Produccion());
        setDatos(data);
        produccion.update();
    }
  @Override
    public void eliminar(int id) {
        produccion = Produccion.find(id, ()->new Produccion());
        produccion.delete();
    }
    private void setDatos(Map<String, Object> data) {
        produccion.setFecha_produccion((String) data.get("fecha_produccion"));
        produccion.setEstado((String) data.get("estado"));
        produccion.setTipo((String) data.get("tipo"));
        produccion.setId_empleado((int) data.get("id_empleado")); 
    }
    
}
