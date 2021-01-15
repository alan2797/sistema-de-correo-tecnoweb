/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.Cliente;
import java.util.List;
import java.util.Map;
import persistencia.Model;

/**
 *
 * @author BLADIMIR
 */
public class NCliente implements INegocio<Cliente>{
    
    private Cliente cliente;

    public NCliente() {
        
    }
    
    @Override
    public Cliente get(int id) {
    return cliente.find(id, ()->new Cliente());
    }

    @Override
    public List<Cliente> getALL() {
    return cliente.all(()->new Cliente());
    }

    @Override
    public int registrar(Map<String, Object> data) {
        cliente = new Cliente();
        setDatos(data);
        cliente.save();
        return 0;
    }

    @Override
    public void modificar(Map<String, Object> data) {
        cliente = Cliente.find((int)data.get("id"), ()->new Cliente());
        setDatos(data);
        cliente.update();
    }
  @Override
    public void eliminar(int id) {
        cliente = Cliente.find(id, ()->new Cliente());
        cliente.delete();
    }

    private void setDatos(Map<String, Object> data) {
        cliente.setNombre((String) data.get("nombre"));
        cliente.setApellido((String) data.get("apellido"));
        cliente.setDireccion((String) data.get("direccion"));
        cliente.setTelefono((String) data.get("telefono"));
        cliente.setEmail((String) data.get("email"));
    }   
}
