/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.Detallecomprbante;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BLADIMIR
 */
public class NDetalleComprobantee implements INegocio<Detallecomprbante>{
      private Detallecomprbante detalle;

    public NDetalleComprobantee() {
    }
    
    @Override
    public Detallecomprbante get(int id) {
    return Detallecomprbante.find(id, ()->new Detallecomprbante());
    }

    @Override
    public List<Detallecomprbante> getALL() {
    return Detallecomprbante.all(()->new Detallecomprbante());
    }

    @Override
    public int registrar(Map<String, Object> data) {
        detalle = new Detallecomprbante();
        setDatos(data);
        detalle.save();
        return 0;
    }

    @Override
    public void modificar(Map<String, Object> data) {
        detalle = Detallecomprbante.find((int)data.get("id"), ()->new Detallecomprbante());
        setDatos(data);
        detalle.update();
    }
  @Override
    public void eliminar(int id) {
        detalle = Detallecomprbante.find(id, ()->new Detallecomprbante());
        detalle.delete();
    }

    private void setDatos(Map<String, Object> data) {
        detalle.setCantidad((int) data.get("cantidad"));
        detalle.setSubtotal((float) data.get("subtotal"));
        detalle.setId_producto((int) data.get("id_producto"));
        detalle.setId_comprobante((int) data.get("id_comprobante"));
        detalle.setId_distribucion((int) data.get("id_distribucion"));
    }
    
}
