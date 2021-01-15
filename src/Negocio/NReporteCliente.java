/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import datos.ReporteCliente;
import java.util.List;
import java.util.Map;
import persistencia.Model;

/**
 *
 * @author vladimir alan PC
 */
public class NReporteCliente implements INegocio<ReporteCliente>{
    private ReporteCliente reporte_cliente;

    public NReporteCliente() {
        
    }
    @Override
    public ReporteCliente get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReporteCliente> getALL() {
        return reporte_cliente.reporteCliente(()->new ReporteCliente());
    }

    @Override
    public int registrar(Map<String, Object> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Map<String, Object> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
