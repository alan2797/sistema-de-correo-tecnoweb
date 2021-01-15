/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

/**
 *
 * @author cesarFuentes
 */
public class Token {
    // Constantes
    public static final int NUM = 0; // Numero Valor
    public static final int STRING = 1; // String Constante
    public static final int FUNC = 2; // Alguna Funcion
    public static final int GB = 3; //Guion Bajo
    public static final int CA = 4; // Corchete Abierto
    public static final int CC = 5; // Corchete Cerrado
    public static final int COMA = 6; // Coma ,
    public static final int FIN = 7;
    public static final int ERROR = 8;
    public static final int TRUE = 9;
    public static final int FALSE = 10;
    public static final int HELP = 11;
    public static final int EOF = 12;
    /// EMPLEADO PANADERIA
    public static final int REGISTRAREMPLEADO = 200;
    public static final int MODIFICAREMPLEADO = 201;    //ya
    public static final int OBTENEREMPLEADO = 202;
    public static final int ELIMINAREMPLEADO = 203;
                            
     //---CLIENTE PANADERIA----------
    public static final int REGISTRARCLIENTE = 204;
    public static final int MODIFICARCLIENTE = 205;
    public static final int OBTENERCLIENTE = 206;
    public static final int ELIMINARCLIENTE = 207;
   //FICHA PRODUCCION PANADERIA
    public static final int REGISTRARFICHAPRODUCCION = 208;
    public static final int MODIFICARFICHAPRODUCCION = 209;
    public static final int OBTENERFICHAPRODUCCION = 210;         //ya
    public static final int ELIMINARFICHAPRODUCCION = 211;
     //DETALLECOMPROBANTE
    public static final int REGISTRARDETALLECOMPROBANTE = 212;
    public static final int MODIFICARDETALLECOMPROBANTE = 213;           //ya
    public static final int OBTENERDETALLECOMPROBANTE = 214;
    public static final int ELIMINARDETALLECOMPROBANTE = 215;
   //COMPROBANTE PANADERIA
    public static final int REGISTRARCOMPROBANTE = 216;
    public static final int MODIFICARCOMPROBANTE = 217;
    public static final int OBTENERCOMPROBANTE = 218;        //ya
    public static final int ELIMINARCOMPROBANTE = 219;
     //PANADERIA PRODUCTO
    public static final int REGISTRARPRODUCTO = 220;
    public static final int MODIFICARPRODUCTO = 221;
    public static final int OBTENERPRODUCTO = 222;       //ya
    public static final int ELIMINARPRODUCTO = 223;
    //SERVICIO
    public static final int REGISTRARINSUMO = 224;
    public static final int MODIFICARINSUMO = 225;       //ya
    public static final int OBTENERINSUMO = 226;
    public static final int ELIMINARINSUMO = 227;
    //PRODUCCION PANADERIA
    public static final int REGISTRARPRODUCCION = 228;
    public static final int MODIFICARPRODUCCION = 229;         
    public static final int OBTENERPRODUCCION = 230;
    public static final int ELIMINARPRODUCCION = 231;
     //public static final int OBTENERREPORTETRANSACCION=232;
     
    public static final int REGISTRARPROVEEDOR = 232;
    public static final int MODIFICARPROVEEDOR = 233;           
    public static final int OBTENERPROVEEDOR = 234;
    public static final int ELIMINARPROVEEDOR =235;
 ///DISTRIBUCION PANAADERIA
     public static final int REGISTRARDISTRIBUCION = 236;
    public static final int MODIFICARDISTRIBUCION = 237;           
    public static final int OBTENERDISTRIBUCION = 238;
    public static final int ELIMINARDISTRIBUCION =239;
    //public static final int REGISTRARARCHIVO = 236;
    //public static final int MODIFICARARCHIVO = 237;
    //public static final int OBTENERARCHIVOS = 238;
    //public static final int ELIMINARARCHIVO = 239;
    //public static final int OBTENERREPORTEAULA = 240;
    ///REPORTES DE PANADERIA
    public static final int REPORTEXCLIENTE = 240;
    public static final int REPORTEXPRODUCTO = 241;

   
    
    private int nombre;
    private int atributo;
    private String toStr;

    public Token() {
    }

    public Token(int nombre, int atributo, String toStr) {
        this.nombre = nombre;
        this.atributo = atributo;
        this.toStr = toStr;
//        System.out.println(toStr);
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getAtributo() {
        return atributo;
    }

    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

    public String getToStr() {
        return toStr;
    }

    public void setToStr(String toStr) {
        this.toStr = toStr;
    }

    
}
