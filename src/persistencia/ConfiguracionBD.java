/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author Franklin
 */
public interface ConfiguracionBD {
    
    public TipoBD getTipoBD();
    public String getNombreDeHost();
    public String getNumeroDePuerto();
    public String getNombreDeBaseDeDato();
    public String getNombreDeUsuario();
    public String getPassword();
    
}
