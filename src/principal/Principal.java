/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import utils.*;
import correo.ClienteSMTP;
import correo.MimeMail;
import correo.SimuladorSMTP;
import java.util.HashMap;
import java.util.Map;

import Negocio.NCliente;
import Negocio.NFichaProduccion;
import Negocio.NDetalleComprobantee;
import Negocio.NComprobante;
import Negocio.NDistribucion;
import Negocio.NProducto;
//DIRECTIVA
import Negocio.NEmpleado;
//DIRECTIVA
import Negocio.NInsumo;
import Negocio.NProduccion;
import Negocio.NProveedor;
import Negocio.NReporteCliente;
import Negocio.NReporteProducto;
import procesador.*;

/**
 *
 *
 */
public class Principal {

        ClienteSMTP ClienteSMTP;

    public Principal() {
       ClienteSMTP = new ClienteSMTP();
    }

    public void processMessage(String Message) {
        //--------------obtengo el correo destinatario------------
     String destinatario = Utils.getDestinatario(Message);
    // String destinatario = "bladimir_12695330@hotmail.com";
          //String destinatario = "blatptp@gmail.com";
     System.out.println("Destinatario: " + destinatario);
//-------------fin obtengo el correo destinatario-----------------  

        //--------------obtengo el asunto-------------------
     String asunto = Utils.getAsunto(Message);
/*=============================================
              CRUD DIR6ECTIVA
 ==============================================*/
   
 // String asunto = "REGISTRARDIRECTIVA [\"directiva3\",\"15-01-2019\",\"15-02-2020\",\"buen año\"]";
        

//    String asunto = "OBTENERUSERSDIRECTOR";
//    String asunto =  "ELIMINARUSERDIRECTOR [35]";      
/*=============================================
        CRUD PROFESOR
 ==============================================*/
//   String asunto = "REGISTRARUSERPROFESOR [123,123,\"profesor\",\"profe\",635,\"direccion\",\"profe@gmail.com\"]";        
        //String asunto = "REGISTRARUSERDIRECTOR help";
     //   String asunto = "REGISTRARUSERDIRECTOR [942291,21438646,\"nombre\",\"apellido\",74545634,\"direccion\"]";
 //       String asunto = "REGISTRARUSERDIRECTOR [123,123,\"cesar\",\"fuentes\",43634,\"direcc\"]";
        //String asunto = "MODIFICARUSERDIRECTOR [123,123,\"cesar\",\"fuentes\",43634,\"direcc\"]";
        

    //    String asunto = "REGISTRARCICLO help";
        //String asunto = "REGISTRARCRONOGRAMA[\"INICIO\",\"FIN\"]";
        //String asunto = "registrarcargo[\"sds\"]";
   //     String asunto =  "registrarcronograma[\"01/01/2018\" , \"25/12/2018\"]";
        
        System.out.println("asunto: " + asunto);
//----ss-ss-sssssssss--s-----fin obtengo asunto-------------------------------------  

        Cinta cinta = new Cinta(asunto);
        AnalizadorLex analex = new AnalizadorLex(cinta);
        Parser parser = new Parser(analex);
        //verificar Expresiones
        parser.Expresion();
        if (parser.errorFlag) {
            // Enviar Correo de Error
            ClienteSMTP.sendMail(destinatario, "Error de Comando",
                    "El comando introducido es incorrecto, trate consultando las ayudas con BTP  el comando HELP"
            );
            return;
        }
        // Si todo va bien, procesar el Comando
        analex.Init();
        Token token = analex.Preanalisis();
        if (token.getNombre() == Token.HELP) {
            // Mostrar Ayudas
            ClienteSMTP.sendMail(destinatario, "Ayudas ", Helper.HELP_GLOBAL);
            System.out.println("send success");
            return;
        }

        switch (token.getAtributo()) {
            //CLIENTE PANADERIA
            case Token.REGISTRARCLIENTE:
                System.out.println(analex);
                 registrarCliente(analex, destinatario);
                break;
            case Token.MODIFICARCLIENTE:
                modificarCLIENTE(analex, destinatario);
                break;
            case Token.ELIMINARCLIENTE:
                 eliminarCLIENTE(analex, destinatario);
                break;
            case Token.OBTENERCLIENTE:
                obtenerCLIENTE(analex, destinatario);
                break;
                ////----FIN CLIENTE---- 
                //FICHAPRODUCCION PANADERIA
            case Token.REGISTRARFICHAPRODUCCION:
                 registrarFICHAPRODUCCION(analex, destinatario);
                break;
            case Token.MODIFICARFICHAPRODUCCION:
               modificarFICHAPRODUCCION(analex, destinatario);
                break;
            case Token.ELIMINARFICHAPRODUCCION:
              eliminarFICHAPRODUCCION(analex, destinatario);
                break;
            case Token.OBTENERFICHAPRODUCCION:
                obtenerFICHAPRODUCCION(analex, destinatario);
                break;
                //DETALLE COMPROBANTE PANADERIA
            case Token.REGISTRARDETALLECOMPROBANTE:
                registrarDETALLECOMPROBANTE(analex, destinatario);
                break;
            case Token.MODIFICARDETALLECOMPROBANTE:
               modificarDETALLECOMPROBANTE(analex, destinatario);
                break;
            case Token.ELIMINARDETALLECOMPROBANTE:
               eliminarDETALLECOMPROBANTE(analex, destinatario);
                break;
            case Token.OBTENERDETALLECOMPROBANTE:
               obtenerDETALLECOMPROBANTE(analex, destinatario);
                break;
                //--EMPLEADO PANADERIA
            case Token.REGISTRAREMPLEADO:
                registrarEMPLEADO(analex, destinatario);
                break;
            case Token.MODIFICAREMPLEADO:
                modificarEMPLEADO(analex, destinatario);
                break;
            case Token.OBTENEREMPLEADO:
                obtenerEMPLEADO(analex, destinatario);
                break;
            case Token.ELIMINAREMPLEADO:
                //EMPLEADO
                System.out.println("cccc");
                eliminarEMPLEADO(analex, destinatario);
                break;
  //HASTA AQUI EMPLEADO
                
  //-----------------COMPROBANTE PANADERIA-----------------------------------------------------------------------------------------------------------            
            case Token.REGISTRARCOMPROBANTE:
                registrarCOMPROBANTE(analex, destinatario);
                break;
            case Token.MODIFICARCOMPROBANTE:
                modificarCOMPROBANTE(analex, destinatario);
                break;
            case Token.OBTENERCOMPROBANTE:
                obtenerCOMPROBANTE(analex, destinatario);
                break;
            case Token.ELIMINARCOMPROBANTE:
                 eliminarCOMPROBANTE(analex, destinatario);
                break;
                //-----PRODUCTO PANADERIA
            case Token.REGISTRARPRODUCTO:
              registrarPRODUCTO(analex, destinatario);
                break;
            case Token.MODIFICARPRODUCTO:
                modificarPRODUCTO(analex, destinatario);
                break;
            case Token.ELIMINARPRODUCTO:
                eliminarPRODUCTO(analex, destinatario);
                break;
            case Token.OBTENERPRODUCTO:
                obtenerPRODUCTO(analex, destinatario);
                break;
                ///INSUMO
            case Token.REGISTRARINSUMO:
                registrarINSUMO(analex, destinatario);
                break;
            case Token.MODIFICARINSUMO:
                modificarINSUMO(analex, destinatario);
                break;
            case Token.ELIMINARINSUMO:
                eliminarINSUMO(analex, destinatario);
                break;
            case Token.OBTENERINSUMO:
                obtenerINSUMO(analex, destinatario);
                break;
            case Token.REGISTRARPRODUCCION:
                registrarPRODUCCION(analex, destinatario);
                break;
            case Token.OBTENERPRODUCCION:
                obtenerPRODUCCION(analex, destinatario);
                break;
            case Token.ELIMINARPRODUCCION:
               eliminarPRODUCCION(analex, destinatario);
                break;
              case Token.MODIFICARPRODUCCION:
               modificarPRODUCCION(analex, destinatario);
                break;
                  //PROVEEDOR
               case Token.REGISTRARPROVEEDOR:
                registrarPROVEEDOR(analex, destinatario);
                break;
               case Token.OBTENERPROVEEDOR:
                obtenerPROVEEDOR(analex, destinatario);
                break;
                 case Token.ELIMINARPROVEEDOR:
                 eliminarPROVEEDOR(analex, destinatario);
                 break;
               case Token.MODIFICARPROVEEDOR:
                 modificarPROVEEDOR(analex, destinatario);
                break;
                   
                  //DISTRIBUCION
                case Token.REGISTRARDISTRIBUCION:
                registrarDISTRIBUCION(analex, destinatario);
                break;
               case Token.OBTENERDISTRIBUCION:
                obtenerDISTRIBUCION(analex, destinatario);
                break;
                 case Token.ELIMINARDISTRIBUCION:
                 eliminarDISTRIBUCION(analex, destinatario);
                 break;
               case Token.MODIFICARDISTRIBUCION:
                 modificarDISTRIBUCION(analex, destinatario);
                break;
                
                //REPORTES
               case Token.REPORTEXCLIENTE:
                    obtenerREPORTECLIENTES(analex, destinatario);
                break;
               case Token.REPORTEXPRODUCTO:
                    obtenerREPORTEPRODUCTOS(analex, destinatario);
                break;
        }

    }
    private void obtenerREPORTEPRODUCTOS(AnalizadorLex analex, String destinatario) {
        NReporteProducto nReporteProducto = new NReporteProducto();
        analex.Avanzar();
        String message = Utils.dibujarTablaREPORTEPRODUCTOConHTML(nReporteProducto.getALL());
        MimeMail mailer = new MimeMail();
        try {
            System.out.println(message);
            mailer.sendHtmlEmail(destinatario, "ObtenerREPORTECLIENTE", "<h1>REPORTE DE PRODUCTOS (APORTE)</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
        
    }
    private void obtenerREPORTECLIENTES(AnalizadorLex analex, String destinatario) {
        NReporteCliente nReporteCliente = new NReporteCliente();
        analex.Avanzar();
        String message = Utils.dibujarTablaREPORTECLIENTEConHTML(nReporteCliente.getALL());
        String message2 = "<!DOCTYPE html>\n"
                + "<head>\n"
                + "<style>\n"
                + ".button {\n"
                + "    background-color: #4CAF50; /* Green */\n"
                + "    border: none;\n"
                + "    color: white;\n"
                + "    padding: 15px 32px;\n"
                + "    text-align: center;\n"
                + "    text-decoration: none;\n"
                + "    display: inline-block;\n"
                + "    font-size: 16px;\n"
                + "    margin: 4px 2px;\n"
                + "    cursor: pointer;\n"
                + "}\n"
                + "\n"
                + ".button2 {background-color: #008CBA;} /* Blue */\n"
                + ".button3 {background-color: #f44336;} /* Red */ \n"
                + ".button4 {background-color: #e7e7e7; color: black;} /* Gray */ \n"
                + ".button5 {background-color: #555555;} /* Black */"
                + "table {\n"
                + "    border-collapse: collapse;\n"
                + "    width: 100%;\n"
                + "}\n"
                + "\n"
                + "th, td {\n"
                + "    text-align: left;\n"
                + "    padding: 8px;\n"
                + "}\n"
                + "\n"
                + "tr:nth-child(even){background-color: #f2f2f2}\n"
                + "\n"
                + "th {\n"
                + "    background-color: #4CAF50;\n"
                + "    color: white;\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "<div class=\"w3-container\">\n"
                + "\n"
                + "<table class=\"w3-table-all\">\n"
                + "<thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>NOMBRE</th> \n"
                + "<th>DIRECCION</th> \n"
                + "<th>TELEFONO</th> \n"
                + "<th>EMAIL</th> \n"
                + "<th>FECHA COMPRA</th> \n"
                + "<th>TOTAL</th> \n"
                + "<th>ESTADO</th> \n"
                + "</tr> \n"
                + "</thead> \n"
                + "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";
        MimeMail mailer = new MimeMail();
        try {
            System.out.println(message);
            mailer.sendHtmlEmail(destinatario, "ObtenerREPORTECLIENTE", "<h1>REPORTE CLIENTE FRECUENTES</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
        
    }
    private void registrarCliente(AnalizadorLex analex, String destinatario) {
        NCliente nCliente = new NCliente();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String apellido = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String direccion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String telefono = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String email = Utils.quitarComillas(analex.Preanalisis().getToStr());
        
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
             data.put("nombre", nombre);
            data.put("apellido", apellido);
            data.put("direccion", direccion);
            data.put("telefono", telefono);
            data.put("email", email);
       
            nCliente.registrar(data);
            mailer.sendHtmlEmail(destinatario, "Registrar Cliente", "Registro realizado"
                    + " correctamente\n" + Utils.dibujarTablaCLIENTEConHTML(nCliente.getALL()));
//            ClienteSMTP.sendMail(destinatario, "Registrar Cargo", "Registro realizado"
//                    + " correctamente\n" + Utils.dibujarTablaCargoConHTML(nCargo.getALL()));
          System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }

    private void modificarCLIENTE(AnalizadorLex analex, String destinatario) {
       NCliente nCliente = new NCliente();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String apellido = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String direccion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String telefono = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String  email = Utils.quitarComillas(analex.Preanalisis().getToStr());

        
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("nombre", nombre);
            data.put("apellido", apellido);
            data.put("direccion", direccion);
            data.put("telefono", telefono);
            data.put("email", email);
               nCliente.modificar(data);
               mailer.sendHtmlEmail(destinatario, "Modificar Cliente", "Modificacion realizada "
                    + "correctamente\n" + Utils.dibujarTablaCLIENTEConHTML(nCliente.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }

    private void obtenerCLIENTE(AnalizadorLex analex, String destinatario) {
            NCliente nCliente = new NCliente();
        analex.Avanzar();
        String message = Utils.dibujarTablaCLIENTEConHTML(nCliente.getALL());
        MimeMail mailer = new MimeMail();
        try {
            mailer.sendHtmlEmail(destinatario, "ObtenerCLIENTE", "<h1>cLIENTE</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
        
    }

    private void eliminarCLIENTE(AnalizadorLex analex, String destinatario) {
        NCliente nCliente = new NCliente();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());

        MimeMail mailer = new MimeMail();
        try {
            nCliente.eliminar(id);
            mailer.sendHtmlEmail(destinatario, "Eliminar cliente", "Eliminacion "
                    + "Correcta\n" + Utils.dibujarTablaCLIENTEConHTML(nCliente.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
   /////----hasta aqui cliente panaderia
    //----FICHA PRODUCCION
  private void registrarFICHAPRODUCCION(AnalizadorLex analex, String destinatario) {
        

       NFichaProduccion nFichaproduccion = new NFichaProduccion();
           
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int cantidad = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String fecha  = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String tipopan = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_produccion = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_insumo = Integer.valueOf(analex.Preanalisis().getToStr());

        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("cantidad", cantidad);
            data.put("fecha", fecha);
            data.put("tipopan", tipopan);
            data.put("id_produccion", id_produccion);
            data.put("id_insumo",id_insumo);
          
            nFichaproduccion.registrar(data);
            mailer.sendHtmlEmail(destinatario, "registrarFICHAPRODUCCION", "Registro "
                    + "realizado correctamente\n" + Utils.dibujarTablaFICHAPRODUCCIONConHTML(nFichaproduccion.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }

    private void modificarFICHAPRODUCCION(AnalizadorLex analex, String destinatario) {
        NFichaProduccion nfichaproduccion = new NFichaProduccion();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int cantidad = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String fecha = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String tipopan = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_produccion = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_insumo = Integer.valueOf(analex.Preanalisis().getToStr());

        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("cantidad", cantidad);
            data.put("fecha", fecha);
            data.put("tipopan", tipopan);
            data.put("id_produccion", id_produccion);
            data.put("id_insumo",id_insumo);
            nfichaproduccion.modificar(data);
            mailer.sendHtmlEmail(destinatario, "modificarFICHAPRODUCCION", "Modificacion "
                    + "correctamente\n" + Utils.dibujarTablaFICHAPRODUCCIONConHTML(nfichaproduccion.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }

    private void obtenerFICHAPRODUCCION(AnalizadorLex analex, String destinatario) {
        NFichaProduccion nFichaproduccion = new NFichaProduccion();
        analex.Avanzar();
        String message = Utils.dibujarTablaFICHAPRODUCCIONConHTML(nFichaproduccion.getALL());
        System.out.println(message);
        MimeMail mailer = new MimeMail();
        try {
            mailer.sendHtmlEmail(destinatario, "obtenerFICHAPRODUCCION", "<h1>ficha de produccion</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
    }

    private void eliminarFICHAPRODUCCION(AnalizadorLex analex, String destinatario) {
        NFichaProduccion nFichaproduccion = new NFichaProduccion();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        Integer id = Integer.valueOf(analex.Preanalisis().getToStr());

        MimeMail mailer = new MimeMail();
        try {
            nFichaproduccion.eliminar(id);
            mailer.sendHtmlEmail(destinatario, "Eliminar Asistencia", "Eliminacion Correcta\n" + Utils.dibujarTablaFICHAPRODUCCIONConHTML(nFichaproduccion.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
//------------------------DETALLECOMPROBANTE PANADERIA------------------------------------------------------
    private void registrarDETALLECOMPROBANTE(AnalizadorLex analex, String destinatario) {
        NDetalleComprobantee nDetalle = new NDetalleComprobantee();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int cantidad = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        float subtotal = Float.valueOf((analex.Preanalisis().getToStr()));
        analex.Avanzar();
        analex.Avanzar();
        int id_producto = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_comprobante = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_distribucion = Integer.valueOf(analex.Preanalisis().getToStr());
        
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("cantidad", cantidad);
            data.put("subtotal", subtotal);
            data.put("id_producto", id_producto);
            data.put("id_comprobante", id_comprobante);
            data.put("id_distribucion", id_distribucion);
            nDetalle.registrar(data);
            mailer.sendHtmlEmail(destinatario, "Registrar Detalle", "Registro realizado"
                    + "correctamente\n" + Utils.dibujarTablaDETALLECOMPROBANTEConHTML(nDetalle.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            
            
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }

    private void modificarDETALLECOMPROBANTE(AnalizadorLex analex, String destinatario) {
        NDetalleComprobantee nDetalle = new NDetalleComprobantee();
        // Atributos 
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int cantidad = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        float subtotal = Float.valueOf((analex.Preanalisis().getToStr()));
        analex.Avanzar();
        analex.Avanzar();
        int id_producto = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_comprobante = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_distribucion = Integer.valueOf(analex.Preanalisis().getToStr());
        
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("cantidad", cantidad);
            data.put("subtotal", subtotal);
            data.put("id_producto", id_producto);
            data.put("id_distribucion",id_distribucion );;
            nDetalle.modificar(data);
            
            mailer.sendHtmlEmail(destinatario, "Modificar Detalle", "Modificacion "
                    + "correctamente\n" + Utils.dibujarTablaDETALLECOMPROBANTEConHTML(nDetalle.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }

    private void obtenerDETALLECOMPROBANTE(AnalizadorLex analex, String destinatario) {
        NDetalleComprobantee nDetalle = new NDetalleComprobantee();
        analex.Avanzar();
        String message = Utils.dibujarTablaDETALLECOMPROBANTEConHTML(nDetalle.getALL());
        System.out.println(message);
        MimeMail mailer = new MimeMail();
        try {
            mailer.sendHtmlEmail(destinatario, "Obtener Detalle", "<h1>Detalle</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }

    private void eliminarDETALLECOMPROBANTE(AnalizadorLex analex, String destinatario) {
        NDetalleComprobantee nDetalle = new NDetalleComprobantee();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());

        MimeMail mailer = new MimeMail();
        try {
            nDetalle.eliminar(id);
            mailer.sendHtmlEmail(destinatario, "Eliminar Detalle", "Eliminacio "
                    + "Correcta\n" + Utils.dibujarTablaDETALLECOMPROBANTEConHTML(nDetalle.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
////----------------------------COMPROBANTE PANADERIA-----------------------
    private void registrarCOMPROBANTE(AnalizadorLex analex, String destinatario) {
        
        NComprobante nComprobante = new NComprobante();
        // Atributos  //atributo no comente btp
      
        analex.Avanzar();
        analex.Avanzar();
        String fecha_compra = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String estado = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_cliente = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_empleado = Integer.valueOf(analex.Preanalisis().getToStr());
        
    
    //    String email = "cesarfufdntes@gmail.com";
       //btp String password = "123456";
       //btp int idcargo=1;//cargo director
       // System.out.println(id);
        MimeMail mailer = new MimeMail();

        try {
            Map<String, Object> data = new HashMap<>();
  
            data.put("fecha_compra", fecha_compra);
            data.put("estado", estado);
            data.put("id_cliente", id_cliente);
            data.put("id_empleado", id_empleado);
           
       
            nComprobante.registrar(data);
            mailer.sendHtmlEmail(destinatario, "Registro VENTA", "<h1> Registro Success </h1>" + Utils.dibujarTablaCOMPROBANTEConHTML(nComprobante.getALL()));
  
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    
    }
      
    private void modificarCOMPROBANTE(AnalizadorLex analex, String destinatario) {
        NComprobante nComprobante = new  NComprobante();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String fecha_compra = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String estado = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_cliente = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_empleado = Integer.valueOf(analex.Preanalisis().getToStr());
     
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
          data.put("fecha_compra", fecha_compra);
            data.put("estado", estado);
            data.put("id_cliente", id_cliente);
            data.put("id_empleado", id_empleado);
            
            
            nComprobante.modificar(data);
            mailer.sendHtmlEmail(destinatario, "Modificar VENTA", "Modificacion "
                    + "correctamente\n" + Utils.dibujarTablaCOMPROBANTEConHTML(nComprobante.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
// obtener directiva
    private void obtenerCOMPROBANTE(AnalizadorLex analex, String destinatario) {
        NComprobante nComprobante = new NComprobante();
        analex.Avanzar();
        String message = Utils.dibujarTablaCOMPROBANTEConHTML(nComprobante.getALL());
        MimeMail mailer = new MimeMail();
        try {
            mailer.sendHtmlEmail(destinatario, "Obtener COMPROBANTE", "<h1>COMPROBANTE</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
    }
//hasta aqui re directiva
    private void eliminarCOMPROBANTE(AnalizadorLex analex, String destinatario) {
        System.out.println("sdfsdf");
        NComprobante nComprobante = new NComprobante();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
            System.out.println(id);
        MimeMail mailer = new MimeMail();
        try {
            nComprobante.eliminar(id);
            mailer.sendHtmlEmail(destinatario, "Eliminar comprobante", "Eliminacion Correcta\n" + Utils.dibujarTablaCOMPROBANTEConHTML(nComprobante.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
    
    //---------------PRODUCTO PANADERIA---------------------------------
    
     private void registrarPRODUCTO(AnalizadorLex analex, String destinatario) {
        
        NProducto nProducto = new NProducto();
        // Atributos  //atributo no comente btp
        
   
        analex.Avanzar();
        analex.Avanzar();
        String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        float precio = Float.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int Stock = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String tipoproducto = Utils.quitarComillas(analex.Preanalisis().getToStr());
       

        MimeMail mailer = new MimeMail();

        try {
            Map<String, Object> data = new HashMap<>();
  
            data.put("nombre", nombre);
            data.put("precio", precio);
            data.put("Stock", Stock);
            data.put("tipoproducto", tipoproducto);
       
            nProducto.registrar(data);
            mailer.sendHtmlEmail(destinatario, "Registro Producto", "<h1> Registro Success </h1>" + Utils.dibujarTablaPRODUCTOConHTML(nProducto.getALL()));
            System.out.println("Email send.");
        } catch (Exception ex) {
            System.out.println("Failed to send email." + ex.getMessage());
        }
    
    }
      
    private void modificarPRODUCTO(AnalizadorLex analex, String destinatario) {
        NProducto nProducto = new NProducto();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        float precio = Float.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int Stock = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String tipoproducto = Utils.quitarComillas(analex.Preanalisis().getToStr());
        
     

        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("nombre", nombre);
            data.put("precio", precio);
            data.put("Stock", Stock);
            data.put("tipoproducto", tipoproducto);
            
            
            nProducto.modificar(data);
            mailer.sendHtmlEmail(destinatario, "Modificar producto", "Modificacion "
                    + "correctamente\n" + Utils.dibujarTablaPRODUCTOConHTML(nProducto.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
// obtener directiva
    private void obtenerPRODUCTO(AnalizadorLex analex, String destinatario) {
        NProducto nProducto = new NProducto();
        analex.Avanzar();
        String message = Utils.dibujarTablaPRODUCTOConHTML(nProducto.getALL());
        MimeMail mailer = new MimeMail();
        try {
            mailer.sendHtmlEmail(destinatario, "Obtener Producto", "<h1>Producto</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
    }

    private void eliminarPRODUCTO(AnalizadorLex analex, String destinatario) {
        System.out.println("sdfsdf");
        NProducto nProducto = new NProducto();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
            System.out.println(id);
        MimeMail mailer = new MimeMail();
        try {
            nProducto.eliminar(id);
            mailer.sendHtmlEmail(destinatario, "Eliminar Producto", "Eliminacion Correcta\n" + Utils.dibujarTablaPRODUCTOConHTML(nProducto.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
    
    //............INSUMO PANADERIA-----------------------------
         private void registrarINSUMO(AnalizadorLex analex, String destinatario) {
        

         NInsumo nInsumo = new NInsumo();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int cantidadinsumo = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String fecha_compra = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        float precio = Float.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_proveedor = Integer.valueOf(analex.Preanalisis().getToStr());
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("nombre", nombre);
            data.put("cantidadinsumo", cantidadinsumo);
            data.put("fecha_compra", fecha_compra);
            data.put("precio", precio);
            data.put("id_proveedor", id_proveedor); 
            nInsumo.registrar(data);
            mailer.sendHtmlEmail(destinatario, "Registrar Insumo", "Registro realizado"
                    + " correctamente\n" + Utils.dibujarTablaINSUMOConHTML(nInsumo.getALL()));
//            ClienteSMTP.sendMail(destinatario, "Registrar Cargo", "Registro realizado"
//                    + " correctamente\n" + Utils.dibujarTablaCargoConHTML(nCargo.getALL()));
          System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }

    private void modificarINSUMO(AnalizadorLex analex, String destinatario) {
        NInsumo nInsumo = new NInsumo();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int cantidadinsumo = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String fecha_compra = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        float precio =Float.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_proveedor = Integer.valueOf(analex.Preanalisis().getToStr());
        
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("nombre", nombre);
            data.put("cantidadinsumo", cantidadinsumo);
            data.put("fecha_compra", fecha_compra);
            data.put("precio", precio);
             data.put("id_proveedor", id_proveedor);
            nInsumo.modificar(data);
            mailer.sendHtmlEmail(destinatario, "Modificar Insumo", "Modificacion realizada "
                    + "correctamente\n" + Utils.dibujarTablaINSUMOConHTML(nInsumo.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }

    private void obtenerINSUMO(AnalizadorLex analex, String destinatario) {
         NInsumo nInsumo = new NInsumo();
        analex.Avanzar();
        String message = Utils.dibujarTablaINSUMOConHTML(nInsumo.getALL());
        MimeMail mailer = new MimeMail();
        try {
            mailer.sendHtmlEmail(destinatario, "ObtenerINSUMO", "<h1>INSUMO</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
    }

    private void eliminarINSUMO(AnalizadorLex analex, String destinatario) {
        NInsumo nInsumo = new NInsumo();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());

        MimeMail mailer = new MimeMail();
        try {
            nInsumo.eliminar(id);
            mailer.sendHtmlEmail(destinatario, "Eliminar insumo", "Eliminacion "
                    + "Correcta\n" + Utils.dibujarTablaINSUMOConHTML(nInsumo.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
    
    //-----------------PRODUCCION PANADERIA--------------------------
     private void registrarPRODUCCION(AnalizadorLex analex, String destinatario) {
        
        NProduccion nProduccion = new NProduccion();
        // Atributos  //atributo no comente btp
        analex.Avanzar();
        analex.Avanzar();
        String fecha_produccion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String estado = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String tipo = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_empleado = Integer.valueOf(analex.Preanalisis().getToStr());
  
       

        MimeMail mailer = new MimeMail();

        try {
            Map<String, Object> data = new HashMap<>();
  
            data.put("fecha_produccion", fecha_produccion);
            data.put("estado", estado);
            data.put("tipo", tipo);
            data.put("id_empleado", id_empleado);
         
           nProduccion.registrar(data);
            mailer.sendHtmlEmail(destinatario, "registrarPRODUCCION", "<h1> Registro Success </h1>" + Utils.dibujarTablaPRODUCCIONConHTML(nProduccion.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    
    }
      
    private void modificarPRODUCCION(AnalizadorLex analex, String destinatario) {
         NProduccion nProduccion = new NProduccion();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
       String fecha_produccion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String estado = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String tipo = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int id_empleado = Integer.valueOf(analex.Preanalisis().getToStr());
        
     
   
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("fecha_produccion", fecha_produccion);
            data.put("estado", estado);
            data.put("tipo", tipo);
            data.put("id_empleado", id_empleado);
            
            
            nProduccion.modificar(data);
            mailer.sendHtmlEmail(destinatario, "modificarPRODUCCION", "Modificacion "
                    + "correctamente\n" + Utils.dibujarTablaPRODUCCIONConHTML(nProduccion.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
// obtener directiva
    private void obtenerPRODUCCION(AnalizadorLex analex, String destinatario) {
           NProduccion nProduccion = new NProduccion();
        analex.Avanzar();
        String message = Utils.dibujarTablaPRODUCCIONConHTML(nProduccion.getALL());
        MimeMail mailer = new MimeMail();
        try {
            mailer.sendHtmlEmail(destinatario, "obtenerPRODUCCION", "<h1>Produccion</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
    }
//hasta aqui re directiva
    private void eliminarPRODUCCION(AnalizadorLex analex, String destinatario) {
        System.out.println("sdfsdf");
       NProduccion nProduccion = new NProduccion();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
            System.out.println(id);
        MimeMail mailer = new MimeMail();
        try {
            nProduccion.eliminar(id);
            mailer.sendHtmlEmail(destinatario, "eliminarPRODUCCION", "Eliminacion Correcta\n" + Utils.dibujarTablaPRODUCCIONConHTML(nProduccion.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
    
      // --------------------------
    private void registrarEMPLEADO(AnalizadorLex analex, String destinatario) {
        
        NEmpleado Nempleado = new NEmpleado();
        // Atributos  //atributo no comente btp   
        analex.Avanzar();
        analex.Avanzar();
        String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String apellido = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String direccion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String telefono = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
       String tipo = Utils.quitarComillas(analex.Preanalisis().getToStr());
       
    
 
        MimeMail mailer = new MimeMail();

        try {
            Map<String, Object> data = new HashMap<>();
  
            data.put("nombre", nombre);
            data.put("apellido", apellido);
            data.put("direccion", direccion);
            data.put("telefono", telefono);
            data.put("tipo", tipo);
       
            Nempleado.registrar(data);
            mailer.sendHtmlEmail(destinatario, "Registro Empleado", "<h1> Registro Success </h1>" + Utils.dibujarTablaEMPLEADOConHTML(Nempleado.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    
    }
      
    private void modificarEMPLEADO(AnalizadorLex analex, String destinatario) {
        NEmpleado Nempleado = new NEmpleado();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
         String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String apellido = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String direccion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String telefono = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
       String tipo = Utils.quitarComillas(analex.Preanalisis().getToStr());
        
     
        //String email = Utils.quitarComillas(analex.Preanalisis().getToStr());
        //String email = "cesarfufdntes@gmail.com";
       // String password = "123456";
      //  int idcargo=1;//cargo director
        //int idcargo = Integer.valueOf(analex.Preanalisis().getToStr());
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("nombre", nombre);
            data.put("apellido", apellido);
            data.put("direccion", direccion);
            data.put("telefono", telefono);
            data.put("tipo", tipo);
            
            Nempleado.modificar(data);
            mailer.sendHtmlEmail(destinatario, "Modificar Usuario", "Modificacion "
                    + "correctamente\n" + Utils.dibujarTablaEMPLEADOConHTML(Nempleado.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
// obtener Empleado
    private void obtenerEMPLEADO(AnalizadorLex analex, String destinatario) {
        NEmpleado Nempleado = new NEmpleado();
        analex.Avanzar();
        String message = Utils.dibujarTablaEMPLEADOConHTML(Nempleado.getALL());
        MimeMail mailer = new MimeMail();
        try {
            mailer.sendHtmlEmail(destinatario, "Obtener Empleado", "<h1>EMPLEADO</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
    }
//hasta aqui empleado
    private void eliminarEMPLEADO(AnalizadorLex analex, String destinatario) {
        System.out.println("sdfsdf");
        NEmpleado Nempleado = new NEmpleado();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
            System.out.println(id);
        MimeMail mailer = new MimeMail();
        try {
            Nempleado.eliminar(id);
            mailer.sendHtmlEmail(destinatario, "Eliminar EMPLEADO", "Eliminacion Correcta\n" + Utils.dibujarTablaEMPLEADOConHTML(Nempleado.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
    
    //------------------DESDE AQUI PROVEEDOR------------------------------------
     private void registrarPROVEEDOR(AnalizadorLex analex, String destinatario) {
        
        NProveedor Nproveedor = new NProveedor();
        // Atributos  //atributo no comente btp   
        analex.Avanzar();
        analex.Avanzar();
        String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String direccion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String telefono = Utils.quitarComillas(analex.Preanalisis().getToStr());
       
    
 
        MimeMail mailer = new MimeMail();

        try {
            Map<String, Object> data = new HashMap<>();
  
            data.put("nombre", nombre);
            data.put("direccion", direccion);
            data.put("telefono", telefono);
        
       
            Nproveedor.registrar(data);
            mailer.sendHtmlEmail(destinatario, "Registro PROVEEDOR", "<h1> Registro Success </h1>" + Utils.dibujarTablaPROVEEDORConHTML(Nproveedor.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    
    }   
      // ---- MoDIFICAR PROVEEDOR-----
      private void modificarPROVEEDOR(AnalizadorLex analex, String destinatario) {
        NProveedor Nproveedor = new NProveedor();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
         String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String direccion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String telefono = Utils.quitarComillas(analex.Preanalisis().getToStr());
        
     
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("nombre", nombre);
            data.put("direccion", direccion);
            data.put("telefono", telefono);
            
            Nproveedor.modificar(data);
            mailer.sendHtmlEmail(destinatario, "Modificar proveedor", "Modificacion "
                    + "correctamente\n" + Utils.dibujarTablaPROVEEDORConHTML(Nproveedor.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
        private void obtenerPROVEEDOR(AnalizadorLex analex, String destinatario) {
        NProveedor Nproveedor = new NProveedor();
        analex.Avanzar();
        String message = Utils.dibujarTablaPROVEEDORConHTML(Nproveedor.getALL());
        MimeMail mailer = new MimeMail();
        try {
            mailer.sendHtmlEmail(destinatario, "Obtener PROVEEDOR", "<h1>PROVEEDOR</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
    }
        
          private void eliminarPROVEEDOR(AnalizadorLex analex, String destinatario) {
        System.out.println("sdfsdf");
        NProveedor Nproveedor = new NProveedor();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
            System.out.println(id);
        MimeMail mailer = new MimeMail();
        try {
            Nproveedor.eliminar(id);
            mailer.sendHtmlEmail(destinatario, "Eliminar Proveedor", "Eliminacion Correcta\n" + Utils.dibujarTablaPROVEEDORConHTML(Nproveedor.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
          
          /// DISTRIBUCION PANADERIA---
        private void registrarDISTRIBUCION(AnalizadorLex analex, String destinatario) {
        
        NDistribucion Ndistribucion = new NDistribucion();
        // Atributos  //atributo no comente btp   
        analex.Avanzar();
        analex.Avanzar();
        String tipodistribucion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String tipotransporte = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        
   
 
        MimeMail mailer = new MimeMail();

        try {
            Map<String, Object> data = new HashMap<>();
  
            data.put("tipodistribucion",tipodistribucion );
            data.put("tipotransporte", tipotransporte);
            data.put("descripcion", descripcion);
        
       
            Ndistribucion.registrar(data);
            mailer.sendHtmlEmail(destinatario, "Registro DISTRIBUCION", "<h1> Registro Success </h1>" + Utils.dibujarTablaDISTRIBUCIONConHTML(Ndistribucion.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    
    } 
        
         private void modificarDISTRIBUCION(AnalizadorLex analex, String destinatario) {
        NDistribucion Ndistribucion = new NDistribucion();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String tipodistribucion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String tipotransporte = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        
     
        MimeMail mailer = new MimeMail();
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("tipodistribucion",tipodistribucion );
            data.put("tipotransporte", tipotransporte);
            data.put("descripcion", descripcion);
            
            Ndistribucion.modificar(data);
            mailer.sendHtmlEmail(destinatario, "Modificar distribucion", "Modificacion "
                    + "correctamente\n" + Utils.dibujarTablaDISTRIBUCIONConHTML(Ndistribucion.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }
     private void obtenerDISTRIBUCION(AnalizadorLex analex, String destinatario) {
        NDistribucion Ndistribucion = new NDistribucion();
        analex.Avanzar();
        String message = Utils.dibujarTablaDISTRIBUCIONConHTML(Ndistribucion.getALL());
        MimeMail mailer = new MimeMail();
        try {
            mailer.sendHtmlEmail(destinatario, "Obtener Distribucion", "<h1>DISTRIBUCION</h1>" + message);
            System.out.println("Email enviado.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
        }
    }
        
          private void eliminarDISTRIBUCION(AnalizadorLex analex, String destinatario) {
        System.out.println("sdfsdf");
        NDistribucion Ndistribucion = new NDistribucion();
        // Atributos
        analex.Avanzar();
        analex.Avanzar();
        int id = Integer.valueOf(analex.Preanalisis().getToStr());
            System.out.println(id);
        MimeMail mailer = new MimeMail();
        try {
            Ndistribucion.eliminar(id);
            mailer.sendHtmlEmail(destinatario, "Eliminar Distribucion", "Eliminacion Correcta\n" + Utils.dibujarTablaDISTRIBUCIONConHTML(Ndistribucion.getALL()));
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email." + ex.getMessage());
        }
    }    
     
} 
    
