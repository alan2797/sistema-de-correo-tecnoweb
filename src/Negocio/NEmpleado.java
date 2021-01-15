/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.Empleado;
import java.util.List;
import java.util.Map;
import persistencia.Model;


/**
 *
 * @author BLADIMIR
 */
public  class NEmpleado implements INegocio<Empleado>{
   
      private Empleado empleado;

    public NEmpleado() {
    }
    
    @Override
    public Empleado get(int id) {
    return empleado.find(id, ()->new Empleado());
    }

    @Override
    public List<Empleado> getALL() {
    return empleado.all(()->new Empleado());
    }

    @Override
    public int registrar(Map<String, Object> data) {
        empleado = new Empleado();
        setDatos(data);
        empleado.save();
        return 0;
    }

    @Override
    public void modificar(Map<String, Object> data) {
        empleado = Empleado.find((int)data.get("id"), ()->new Empleado());
        setDatos(data);
        empleado.update();
    }
  @Override
    public void eliminar(int id) {
        empleado = Empleado.find(id, ()->new Empleado());
        empleado.delete();
    }

    private void setDatos(Map<String, Object> data) {
        empleado.setNombre((String) data.get("nombre"));
        empleado.setApellido((String) data.get("apellido"));
        empleado.setDireccion((String) data.get("direccion"));
        empleado.setTelefono((String) data.get("telefono"));
        empleado.setTipo((String) data.get("tipo"));
    }
                
}
