
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import persistencia.ConfiguracionBD;
import persistencia.TipoBD;







/**
 *
 * @author Franklin
 */
public class Configuracion implements ConfiguracionBD{

    @Override
    public TipoBD getTipoBD() {
        return TipoBD.POSTGRE;
    }

    @Override
    public String getNombreDeHost() {
    
        return Database.DB_HOST;
    }

    @Override
    public String getNumeroDePuerto() {
        return Database.PORT;
    }

    @Override
    public String getNombreDeBaseDeDato() {
        return Database.DB_NAME;
    }

    @Override
    public String getNombreDeUsuario() {
        return Database.DB_USER;
    }

    @Override
    public String getPassword() {
        return Database.DB_PASSWORD;
    }
    
}