/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.List;
import java.util.Map;

/**
 *
 * @author BLADIMIR
 */
    
    public interface INegocio <T>{
    T get(int id);
    List<T> getALL();
    int registrar(Map<String,Object> data);
    void modificar(Map<String,Object> data);
    void eliminar(int id);
    
    
    
}

