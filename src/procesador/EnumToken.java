/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

/**
 *
 * @author Franklin
 */
public enum EnumToken {
     HELP(Token.HELP,-1),
     TRUE(Token.TRUE,-1),
     FALSE(Token.FALSE,-1),
     //EMPLEADO PANADERIA
     REGISTRAREMPLEADO(200),
     MODIFICAREMPLEADO(201),
     OBTENEREMPLEADO(202),
     ELIMINAREMPLEADO(203),
// -----CLIENTE PANADERIA-------
     REGISTRARCLIENTE(204),
     MODIFICARCLIENTE(205),
     OBTENERCLIENTE(206),
     ELIMINARCLIENTE(207),
  /// FICHAPRODUCCION
     REGISTRARFICHAPRODUCCION(208),
     MODIFICARFICHAPRODUCCION(209),
     OBTENERFICHAPRODUCCION(210),
     ELIMINARFICHAPRODUCCION(211),
     //DETALLECOMPROBANTE PANADERIA
     REGISTRARDETALLECOMPROBANTE(212),
     MODIFICARDETALLECOMPROBANTE(213),
     OBTENERDETALLECOMPROBANTE(214),
     ELIMINARDETALLECOMPROBANTE(215),
     ////---COMPROOBANTE PANADERIA-------
     REGISTRARCOMPROBANTE(216),
     MODIFICARCOMPROBANTE(217),
     OBTENERCOMPROBANTE(218),
     ELIMINARCOMPROBANTE(219),
     //PRODUCTO PANADERIA
    REGISTRARPRODUCTO(220),
     MODIFICARPRODUCTO(221),
    OBTENERPRODUCTO(222),
     ELIMINARPRODUCTO(223),
     //INSUMO PnDERIA
     REGISTRARINSUMO(224),
     MODIFICARINSUMO(225),
     OBTENERINSUMO(226),
     ELIMINARINSUMO(227),
     // PRODUCCION PANADERIA
     REGISTRARPRODUCCION(228),
     MODIFICARPRODUCCION(229),
     OBTENERPRODUCCION(230),
     ELIMINARPRODUCCION(231),   
   ///  ----proveedor----Panaderia------------
     REGISTRARPROVEEDOR(232),
     MODIFICARPROVEEDOR(233),
     OBTENERPROVEEDOR(234),
     ELIMINARPROVEEDOR(235),  
     ////---DISTRIBUCION PANADERIA----
      REGISTRARDISTRIBUCION(236),
     MODIFICARDISTRIBUCION(237),
     OBTENERDISTRIBUCION(238),
     ELIMINARDISTRIBUCION(239), 
     ////---REPORTE CLIENTE----
     REPORTEXCLIENTE(240), 
        REPORTEXPRODUCTO(241)
  
     
     
     ;
     private  final int comando;
     private  final int valor;
     
    private EnumToken(int comando,int valor) {
        this.valor = valor;
        this.comando = comando;
    }
        private EnumToken(int valor) {
        this.valor = valor;
        this.comando = Token.FUNC;
    }

    public int getValor() {
        return valor;
    }

    public int getComando() {
        return comando;
    }


         
}
