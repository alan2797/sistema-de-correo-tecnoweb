/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.Distribucion;

import java.util.List;
import java.util.Map;

/**
 *
 * @author BLADIMIR
 */
public class NDistribucion implements INegocio<Distribucion>{

     private Distribucion distribucion;

    public NDistribucion() {
        
    }

    @Override
    public Distribucion get(int id) {
        return Distribucion.find(id,() -> new Distribucion());
    }

    @Override
    public List<Distribucion> getALL() {
        return  Distribucion.all(()->new Distribucion());
    }

    @Override
    public int registrar(Map<String, Object> data) {
       distribucion = new Distribucion();
        setDatos(data);
        distribucion.save();
        return 0;
    }

    @Override
    public void modificar(Map<String, Object> data) {
         distribucion = Distribucion.find((int)data.get("id"),()->new Distribucion());
        setDatos(data);
        distribucion.update();
    }

    @Override
    public void eliminar(int id) {
         distribucion = Distribucion.find(id, ()-> new Distribucion());
         distribucion.delete();
    }
      
     private void setDatos(Map<String, Object> data) {  
       distribucion.setTipodistribucion((String) data.get("tipodistribucion"));
       distribucion.setTipotransporte((String) data.get("tipotransporte"));
       distribucion.setDescripcion((String) data.get("descripcion"));
       
    }
    
    
}
