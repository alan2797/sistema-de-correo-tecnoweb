/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnobtp;

import Negocio.NEmpleado;
import datos.Empleado;
import java.util.HashMap;
import java.util.Map;
import static jdk.nashorn.internal.objects.Global.print;
import persistencia.Conector;
import presentacion.FormServicio;
import principal.Principal;
import utils.Configuracion;

/**
 *
 * @author BLADIMIR
 */
public class TecnoBTP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conector c = Conector.getInstancia();
        c.setConfiguracionBD(new Configuracion());
        
    
    
 //       System.out.println(nCargo.getALL());
          FormServicio servicio = new FormServicio();
         servicio.setVisible(true);
     
    }
    
}
