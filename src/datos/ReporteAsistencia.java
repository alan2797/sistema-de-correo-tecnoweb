/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.Conector;
import persistencia.Model;
import datos.Cliente;
import datos.FichaProduccion;

/**
 *
 * @author cesarFuentes
 */
public class ReporteAsistencia {
  private Cliente socio;
  private FichaProduccion asisten;
  public  ReporteAsistencia(){
    
    }

    public String getNombre_socio() {
        return   socio.getNombre();
    }


 //public String getAsistencia() {
   //     return asisten.getAsistencia();
    ///}   
}
