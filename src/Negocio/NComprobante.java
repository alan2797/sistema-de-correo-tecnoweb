/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.Comprobante;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BLADIMIR
 */
public class NComprobante implements INegocio<Comprobante>{
      private Comprobante comprobante;

    public NComprobante() {
    }
    
    @Override
    public Comprobante get(int id) {
    return Comprobante.find(id, ()->new Comprobante());
    }

    @Override
    public List<Comprobante> getALL() {
    return Comprobante.all(()->new Comprobante());
    }

    @Override
    public int registrar(Map<String, Object> data) {
        comprobante = new Comprobante();
        setDatos(data);
        comprobante.save();
        return 0;
    }

    @Override
    public void modificar(Map<String, Object> data) {
        comprobante = Comprobante.find((int)data.get("id"), ()->new Comprobante());
        setDatos(data);
        comprobante.update();
    }
  @Override
    public void eliminar(int id) {
        comprobante = Comprobante.find(id, ()->new Comprobante());
        comprobante.delete();
    }

    private void setDatos(Map<String, Object> data) {
        comprobante.setFecha_compra((String) data.get("fecha_compra"));
        comprobante.setEstado((String) data.get("estado"));
        comprobante.setId_clientes((int) data.get("id_cliente"));
        comprobante.setId_empleado((int) data.get("id_empleado"));       
    }    
}
