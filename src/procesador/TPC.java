/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author BLADIMIR
 */
public class TPC {
    

    private static final LinkedList<String> lexemas = new LinkedList<>(Arrays.asList(
            EnumToken.HELP.toString(),
            EnumToken.TRUE.toString(),
            EnumToken.FALSE.toString(),
            ///CLIENTE PANADERIA
            EnumToken.REGISTRARCLIENTE.toString(),
            EnumToken.MODIFICARCLIENTE.toString(),
            EnumToken.OBTENERCLIENTE.toString(),
            EnumToken.ELIMINARCLIENTE.toString(),
            //FICHA PRODUCCION PANADERIA
            EnumToken.REGISTRARFICHAPRODUCCION.toString(),
            EnumToken.MODIFICARFICHAPRODUCCION.toString(),
            EnumToken.OBTENERFICHAPRODUCCION.toString(),
            EnumToken.ELIMINARFICHAPRODUCCION.toString(),
            /// DIRECTIVA
            EnumToken.REGISTRAREMPLEADO.toString(),
            EnumToken.MODIFICAREMPLEADO.toString(),
            EnumToken.OBTENEREMPLEADO.toString(),
            EnumToken.ELIMINAREMPLEADO.toString(),
            //DETALLECOMPROBANTE
            EnumToken.REGISTRARDETALLECOMPROBANTE.toString(),
            EnumToken.MODIFICARDETALLECOMPROBANTE.toString(),
            EnumToken.OBTENERDETALLECOMPROBANTE.toString(),
            EnumToken.ELIMINARDETALLECOMPROBANTE.toString(),
            
                  ///COMPROBANTE PANADERIA      
            EnumToken.REGISTRARCOMPROBANTE.toString(),
            EnumToken.MODIFICARCOMPROBANTE.toString(),
            EnumToken.OBTENERCOMPROBANTE.toString(),
            EnumToken.ELIMINARCOMPROBANTE.toString(),
                       //PRODUCTO PANADERIA 
            EnumToken.REGISTRARPRODUCTO.toString(),
            EnumToken.MODIFICARPRODUCTO.toString(),
            EnumToken.OBTENERPRODUCTO.toString(),
            EnumToken.ELIMINARPRODUCTO.toString(),
            
                  ///INSUMO PANADERIA
            EnumToken.REGISTRARINSUMO.toString(),
            EnumToken.MODIFICARINSUMO.toString(),
            EnumToken.OBTENERINSUMO.toString(),
            EnumToken.ELIMINARINSUMO.toString(),
            
            //PRODUCCION PANADERIA            
            EnumToken.REGISTRARPRODUCCION.toString(),
            EnumToken.MODIFICARPRODUCCION.toString(),
            EnumToken.OBTENERPRODUCCION.toString(),
            EnumToken.ELIMINARPRODUCCION.toString(),
            
            //PRoveedor panaderia            
            EnumToken.REGISTRARPROVEEDOR.toString(),
            EnumToken.MODIFICARPROVEEDOR.toString(),
            EnumToken.OBTENERPROVEEDOR.toString(),
            EnumToken.ELIMINARPROVEEDOR.toString(),
             //DISTRIBUCION PANADERIA----            
            EnumToken.REGISTRARDISTRIBUCION.toString(),
            EnumToken.MODIFICARDISTRIBUCION.toString(),
            EnumToken.OBTENERDISTRIBUCION.toString(),
            EnumToken.ELIMINARDISTRIBUCION.toString(),
            
             //REPORTE CLIENTE----      
            EnumToken.REPORTEXCLIENTE.toString(),      
            EnumToken.REPORTEXPRODUCTO.toString() 
    ));

    private static final LinkedList<Token> tokens = new LinkedList<>(Arrays.asList(
            new Token(Token.HELP, -1, EnumToken.HELP.toString()),
            new Token(Token.TRUE, -1, EnumToken.TRUE.toString()),
            new Token(Token.FALSE, -1,EnumToken.FALSE.toString()),
            ///-----------------------CLIENTE PANADERIA--------------------/
            new Token(Token.FUNC, EnumToken.REGISTRARCLIENTE.getValor(), EnumToken.REGISTRARCLIENTE.toString()),
            new Token(Token.FUNC, EnumToken.MODIFICARCLIENTE.getValor(), EnumToken.MODIFICARCLIENTE.toString()),
            new Token(Token.FUNC, EnumToken.OBTENERCLIENTE.getValor(), EnumToken.OBTENERCLIENTE.toString()),
            new Token(Token.FUNC, EnumToken.ELIMINARCLIENTE.getValor(), EnumToken.ELIMINARCLIENTE.toString()),
            
            new Token(Token.FUNC, EnumToken.REGISTRARFICHAPRODUCCION.getValor(), EnumToken.REGISTRARFICHAPRODUCCION.toString()),
            new Token(Token.FUNC, EnumToken.MODIFICARFICHAPRODUCCION.getValor(), EnumToken.MODIFICARFICHAPRODUCCION.toString()),
            new Token(Token.FUNC, EnumToken.OBTENERFICHAPRODUCCION.getValor(), EnumToken.OBTENERFICHAPRODUCCION.toString()),
            new Token(Token.FUNC, EnumToken.ELIMINARFICHAPRODUCCION.getValor(), EnumToken.ELIMINARFICHAPRODUCCION.toString()),
            
         
            ///----DIRECTIVA
            new Token(Token.FUNC, EnumToken.REGISTRAREMPLEADO.getValor(), EnumToken.REGISTRAREMPLEADO.toString()),
            new Token(Token.FUNC, EnumToken.MODIFICAREMPLEADO.getValor(), EnumToken.MODIFICAREMPLEADO.toString()),
            new Token(Token.FUNC, EnumToken.OBTENEREMPLEADO.getValor(), EnumToken.OBTENEREMPLEADO.toString()),
            new Token(Token.FUNC, EnumToken.ELIMINAREMPLEADO.getValor(), EnumToken.ELIMINAREMPLEADO.toString()),
            //DIRECTIVA
            new Token(Token.FUNC, EnumToken.REGISTRARDETALLECOMPROBANTE.getValor(), EnumToken.REGISTRARDETALLECOMPROBANTE.toString()),
            new Token(Token.FUNC, EnumToken.MODIFICARDETALLECOMPROBANTE.getValor(), EnumToken.MODIFICARDETALLECOMPROBANTE.toString()),
            new Token(Token.FUNC, EnumToken.OBTENERDETALLECOMPROBANTE.getValor(), EnumToken.OBTENERDETALLECOMPROBANTE.toString()),
            new Token(Token.FUNC, EnumToken.ELIMINARDETALLECOMPROBANTE.getValor(), EnumToken.ELIMINARDETALLECOMPROBANTE.toString()),
                                         
            new Token(Token.FUNC, EnumToken.REGISTRARCOMPROBANTE.getValor(), EnumToken.REGISTRARCOMPROBANTE.toString()),
            new Token(Token.FUNC, EnumToken.MODIFICARCOMPROBANTE.getValor(), EnumToken.MODIFICARCOMPROBANTE.toString()),
            new Token(Token.FUNC, EnumToken.OBTENERCOMPROBANTE.getValor(), EnumToken.OBTENERCOMPROBANTE.toString()),
            new Token(Token.FUNC, EnumToken.ELIMINARCOMPROBANTE.getValor(), EnumToken.ELIMINARCOMPROBANTE.toString()),
               ///...PRODUCTO PANADERIA........
            new Token(Token.FUNC, EnumToken.REGISTRARPRODUCTO.getValor(), EnumToken.REGISTRARPRODUCTO.toString()),
            new Token(Token.FUNC, EnumToken.MODIFICARPRODUCTO.getValor(), EnumToken.MODIFICARPRODUCTO.toString()),
            new Token(Token.FUNC, EnumToken.OBTENERPRODUCTO.getValor(), EnumToken.OBTENERPRODUCTO.toString()),
            new Token(Token.FUNC, EnumToken.ELIMINARPRODUCTO.getValor(), EnumToken.ELIMINARPRODUCTO.toString()),
            /////////////INSUMO PANADERIA
            new Token(Token.FUNC, EnumToken.REGISTRARINSUMO.getValor(), EnumToken.REGISTRARINSUMO.toString()),
            new Token(Token.FUNC, EnumToken.MODIFICARINSUMO.getValor(), EnumToken.MODIFICARINSUMO.toString()),
            new Token(Token.FUNC, EnumToken.OBTENERINSUMO.getValor(), EnumToken.OBTENERINSUMO.toString()),
            new Token(Token.FUNC, EnumToken.ELIMINARINSUMO.getValor(), EnumToken.ELIMINARINSUMO.toString()),
            
            new Token(Token.FUNC, EnumToken.REGISTRARPRODUCCION.getValor(), EnumToken.REGISTRARPRODUCCION.toString()),
            new Token(Token.FUNC, EnumToken.MODIFICARPRODUCCION.getValor(), EnumToken.MODIFICARPRODUCCION.toString()),
            new Token(Token.FUNC, EnumToken.OBTENERPRODUCCION.getValor(), EnumToken.OBTENERPRODUCCION.toString()),
            new Token(Token.FUNC, EnumToken.ELIMINARPRODUCCION.getValor(), EnumToken.ELIMINARPRODUCCION.toString()),
            
            new Token(Token.FUNC, EnumToken.REGISTRARPROVEEDOR.getValor(), EnumToken.REGISTRARPROVEEDOR.toString()),
            new Token(Token.FUNC, EnumToken.MODIFICARPROVEEDOR.getValor(), EnumToken.MODIFICARPROVEEDOR.toString()),
            new Token(Token.FUNC, EnumToken.OBTENERPROVEEDOR.getValor(), EnumToken.OBTENERPROVEEDOR.toString()),
            new Token(Token.FUNC, EnumToken.ELIMINARPROVEEDOR.getValor(), EnumToken.ELIMINARPROVEEDOR.toString()), 
            
            new Token(Token.FUNC, EnumToken.REGISTRARDISTRIBUCION.getValor(), EnumToken.REGISTRARDISTRIBUCION.toString()),
            new Token(Token.FUNC, EnumToken.MODIFICARDISTRIBUCION.getValor(), EnumToken.MODIFICARDISTRIBUCION.toString()),
            new Token(Token.FUNC, EnumToken.OBTENERDISTRIBUCION.getValor(), EnumToken.OBTENERDISTRIBUCION.toString()),
            new Token(Token.FUNC, EnumToken.ELIMINARDISTRIBUCION.getValor(), EnumToken.ELIMINARDISTRIBUCION.toString()),
            
            new Token(Token.FUNC, EnumToken.REPORTEXCLIENTE.getValor(), EnumToken.REPORTEXCLIENTE.toString()) , 
            new Token(Token.FUNC, EnumToken.REPORTEXPRODUCTO.getValor(), EnumToken.REPORTEXPRODUCTO.toString())    
    ));

    public static Token estaEnTPC(String lexema) {
        lexema = lexema.toUpperCase();
        for (int i = 0; i < lexemas.size(); i++) {
            if (lexemas.get(i).toUpperCase().equals(lexema)) {
                Token token = new Token();
                token.setNombre(tokens.get(i).getNombre());
                token.setAtributo(tokens.get(i).getAtributo());
                token.setToStr(tokens.get(i).getToStr());
                return token;
            }
        }
        return null;
    }
}