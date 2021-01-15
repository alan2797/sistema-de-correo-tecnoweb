 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.Producto;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BLADIMIR
 */
public class NProducto implements INegocio<Producto>{
      private Producto producto;

    public NProducto() {
        
    }

    @Override
    public Producto get(int id) {
        return Producto.find(id,() -> new Producto());
    }

    @Override
    public List<Producto> getALL() {
        return  Producto.all(()->new Producto());
    }

    @Override
    public int registrar(Map<String, Object> data) {
       producto = new Producto();
        setDatos(data);
        producto.save();
        return 0;
    }

    @Override
    public void modificar(Map<String, Object> data) {
         producto = Producto.find((int)data.get("id"),()->new Producto());
        setDatos(data);
        producto.update();
    }

    @Override
    public void eliminar(int id) {
         producto = Producto.find(id, ()-> new Producto());
         producto.delete();
    }
      
     private void setDatos(Map<String, Object> data) {
         
       producto.setNombre((String) data.get("nombre"));
       producto.setPrecio((float) data.get("precio"));
       producto.setStock((int) data.get("Stock"));
       producto.setTipoproducto((String) data.get("tipoproducto"));
     
    }
    
}
