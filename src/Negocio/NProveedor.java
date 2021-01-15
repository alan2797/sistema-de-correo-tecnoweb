/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.Proveedor;

import java.util.List;
import java.util.Map;

/**
 *
 * @author BLADIMIR
 */
public class NProveedor implements INegocio<Proveedor>{

     private Proveedor proveedor;

    public NProveedor() {
        
    }

    @Override
    public Proveedor get(int id) {
        return Proveedor.find(id,() -> new Proveedor());
    }

    @Override
    public List<Proveedor> getALL() {
        return  Proveedor.all(()->new Proveedor());
    }

    @Override
    public int registrar(Map<String, Object> data) {
       proveedor = new Proveedor();
        setDatos(data);
        proveedor.save();
        return 0;
    }

    @Override
    public void modificar(Map<String, Object> data) {
         proveedor = Proveedor.find((int)data.get("id"),()->new Proveedor());
        setDatos(data);
        proveedor.update();
    }

    @Override
    public void eliminar(int id) {
         proveedor = Proveedor.find(id, ()-> new Proveedor());
         proveedor.delete();
    }
      
     private void setDatos(Map<String, Object> data) {
         
       proveedor.setNombre((String) data.get("nombre"));
       proveedor.setDireccion((String) data.get("direccion"));
       proveedor.setTelefono((String) data.get("telefono"));
       
    }
          
}
