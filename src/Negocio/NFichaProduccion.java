/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.FichaProduccion;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BLADIMIR
 */
public class NFichaProduccion implements INegocio<FichaProduccion>{
    
     private FichaProduccion fichaproduccion;

    public NFichaProduccion() {
        
    }

    @Override
    public FichaProduccion get(int id) {
        return FichaProduccion.find(id,() -> new FichaProduccion());
    }

    @Override
    public List<FichaProduccion> getALL() {
        return  FichaProduccion.all(()->new FichaProduccion());
    }

    @Override
    public int registrar(Map<String, Object> data) {
       fichaproduccion = new FichaProduccion();
        setDatos(data);
        fichaproduccion.save();
        return 0;
    }

    @Override
    public void modificar(Map<String, Object> data) {
         fichaproduccion = FichaProduccion.find((int)data.get("id"),()->new FichaProduccion());
        setDatos(data);
        fichaproduccion.update();
    }

    @Override
    public void eliminar(int id) {
         fichaproduccion = FichaProduccion.find(id, ()-> new FichaProduccion());
         fichaproduccion.delete();
    }
    
    
     private void setDatos(Map<String, Object> data) {
         
      fichaproduccion.setCantidad((int) data.get("cantidad"));
      fichaproduccion.setFecha((String) data.get("fecha"));
      fichaproduccion.setTipopan((String) data.get("tipopan"));
     fichaproduccion.setId_produccion((int) data.get("id_produccion"));
     fichaproduccion.setId_insumo((int) data.get("id_insumo"));
    }
       
}
