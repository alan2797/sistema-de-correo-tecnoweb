/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author bladimir
 */
public class Helper {
    public static final String HELP_GLOBAL = "Bienvenido!!!\n\n"
            + "A continuacion se listaran los comandos disponibles para interactuar con el sistema \n"
            + "REGISTRARPRODUCTO [nombre,precio,Stock,tipoproducto] \n"
            +"reemplazar las comillas dobles en el ejemplo\n"
            +"REGISTRARPRODUCTO ejemplo ['pan francez',0.50,1000,'pan de trigo'] \n"
            + "MODIFICARPRODUCTO [id,nombre,fecha_ini,fecha_fin,descripcion] \n"
            +"MODIFICARPRODUCTO ejemplo [1,'pan francez',0.50,1000,'pan de trigo'] \n"
            + "OBTENERPRODUCTO \n"
            + "ELIMINARPRODUCTO [id] \n"
            +" ------------------------------- \n"
            + "REGISTRARCLIENTE [nombre,apellido,direccion,telefono,email] \n"
            +"reemplazar las comillas dobles en el ejemplo\n"
            + "REGISTRARCLIENTE ejemplo ['bladimir','toco','Avenida Grigota','67847025','btp@gmail.com'] \n"
            +"MODIFICARCLIENTE [id,nombre,apellido,direccion,telefono,email] \n"
            + "MODIFICARCLIENTE ejemplo [1,'bladimir','toco','Calle aroma','67847070','bladimir@gmail.com'] \n"
            + "OBTENERCLIENTE\n"
            + "ELIMINARCLIENTE [id]\n"
            +" ------------------------------- \n"
            + "REGISTRARINSUMO[nombre,cantidadinsumo,fecha_compra,precio,id_proveedor] \n"
            + "REGISTRARINSUMO ejemplo['juan Ramon',25,'12-12-2019','25',1] \n"
            + "MODIFICARINSUMO[1,'juan Ramon',25,'12-12-2019','25',1] \n"
            + "OBTENERINSUMO\n"
            + "ELIMINARINSUMO[id] \n"
            +" -------------GESTIONAR DISTRIBUCION------------------ \n"
            + "REGISTRARDISTRIBUCION[tipodistribucion,tipotransporte,descripcion]\n"
            + "REGISTRARDISTRIBUCION Ejemplo['A DOMICILIO','MOTOSICLETA','TIEMPO DE ENTREGA 1 HOORA']\n"
            + "MODIFICARDISTRIBUCION[1,'A DOMICILIO','MOTOSICLETA','TIEMPO DE ENTREGA 1 HORA']\n"
            + "OBTENERDISTRIBUCION \n"
            + "ELIMINARDISTRIBUCION[id]\n"
            +" ----------GESTIONAR PROVEEDOR--------------------- \n"
            + "REGISTRARPROVEEDOR[nombre,direccion,telefono]\n"
            + "REGISTRARPROVEEDOR Ejemplo['Tomas Rodriguez','Zona el trompillo','6778455']\n"
            + "MODIFICARPROVEEDOR[1,'A DOMICILIO','MOTOSICLETA','TIEMPO DE ENTREGA 1 HORA']\n"
            + "OBTENERPROVEEDOR \n"
            + "ELIMINARPROVEEDOR[id]\n"
            +" -------------GESTIONAR USUARIO ------------------ \n"
            + "REGISTRAREMPLEADO [nombre,apellido,direccion,telefono,tipo]\n"
            + "REGISTRAREMPLEADO ejemplo ['Bladimir','Torrez p','Zona los lotes','78578552','ADMINISTRADOR']\n"
            + "MODIFICAREMPLEADO[1,'Bladimir','Torrez p','Zona los lotes','78578552','ADMINISTRADOR']\n"
            + "OBTENEREMPLEADO \n"
            + "ELIMINAREMPLEADO[id]\n"
            +" --------------GESTIONAR REPORTE PRODUCCION----------------- \n"
            + "REGISTRARFICHAPRODUCCION [cantidad,fecha,tipopan,id_produccion,id_insumo]\n"
            + "REGISTRARFICHAPRODUCCION ejemplo ['1000','25-09-2019','PAN INTEGRAL',1,1]\n"
            + "MODIFICARFICHAPRODUCCION[1,'1000','25-09-2019','PAN INTEGRAL',1,1]\n"
            + "OBTENERFICHAPRODUCCION \n"
            + "ELIMINARFICHAPRODUCCION [id]\n"
            +" -------------------GESTIONAR VENTA------------ \n"
            +"REGISTRARCOMPROBANTE[fecha_compra,estado,id_cliente,id_empleado]\n"
            +"REGISTRARCOMPROBANTE ejemplo ['25-01-2019','cancelado'2,2]\n"
            +"REGISTRARCOMPROBANTE ejemplo [1,'25-01-2019','cancelado'2,2]\n"
            +"MODIFICARCOMPROBANTE \n"
            +"OBTENERCOMPROBANTE [id] \n"
            +" -------------------GESTIONAR PEDIDO------------ \n"
            +"REGISTRARCOMPROBANTE[cantidad,subtotal,id_producto,id_comprobante,id_distribucion]\n"
            +"REGISTRARCOMPROBANTE ejemplo [25,200,1,1,1]\n"
            +"MODIFICARCOMPROBANTE [25,200,1,1,1] \n"
            +"OBTENERCOMPROBANTE [id] \n"
            +" -------------------REPORTE CLIENTES MAS FRECUENTES------------ \n"
            +"REPORTEXCLIENTE \n"
            +"REPORTEXPRODUCTO \n";

    public static final String HELP_REGISTRARDIRECTIVA = "Registro cliente\n"
            + "\n"
            + "El comando que permite registrar  \n"
            + "parametros: REGISTRAR[nombre,fecha_ini,fecha_fin,descripcion]";
   
 
}
