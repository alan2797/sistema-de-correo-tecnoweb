/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.Insumo;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BLADIMIR
 */

    public class NInsumo implements INegocio<Insumo>{
      private Insumo insumo;

    public NInsumo() {
    }
    
    @Override
    public Insumo get(int id) {
    return Insumo.find(id, ()->new Insumo());
    }

    @Override
    public List<Insumo> getALL() {
    return Insumo.all(()->new Insumo());
    }

    @Override
    public int registrar(Map<String, Object> data) {
        insumo = new Insumo();
        setDatos(data);
       insumo.save();
        return 0;
    }

    @Override
    public void modificar(Map<String, Object> data) {
        insumo = Insumo.find((int)data.get("id"), ()->new Insumo());
        setDatos(data);
        insumo.update();
    }

    @Override
    public void eliminar(int id) {
        insumo = Insumo.find(id, ()->new Insumo());
        insumo.delete();
    }

   
    private void setDatos(Map<String, Object> data) {
        insumo.setNombre((String) data.get("nombre"));
        insumo.setCantidadinsumo((int) data.get("cantidadinsumo"));
        insumo.setFecha_compra((String) data.get("fecha_compra"));
         insumo.setPrecio((float) data.get("precio"));
          insumo.setId_proveedor((int) data.get("id_proveedor"));
    }
    
}
