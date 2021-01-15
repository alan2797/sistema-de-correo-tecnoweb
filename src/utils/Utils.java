/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import datos.FichaProduccion;
import datos.Detallecomprbante;
import datos.Comprobante;
import datos.Producto;
import datos.Insumo;
import datos.Cliente;
import datos.Distribucion;
import datos.Produccion;
import datos.Empleado;
import datos.Proveedor;
import datos.ReporteAsistencia;
import datos.ReporteCliente;
import datos.ReporteProducto;

import presentador.Block;
import presentador.Board;
import presentador.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Boris Fernando
 */
public class Utils {

    public static Date convertirFechas(String fecha) {
        // Formato de fecha a ingresar dd-MM-yyyy
        Date fechaNueva = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
            java.util.Date fechaJava = formato.parse(fecha);
            fechaNueva = new Date(fechaJava.getTime());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return fechaNueva;
    }

    public static String getDestinatario(String contenido) {
        String destinatario = "";
        // Dividir en lineas
        String[] lines = contenido.split("\n");
        int index = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 5
                    && lines[i].substring(0, 5).toUpperCase().equals("FROM:")) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            // Quitar la palabra 'From: '
            destinatario = lines[index].substring(6);
            lines = destinatario.split(" ");
            if (lines.length == 1) { // Correo del Server
                destinatario = lines[0];
            } else { // Desde otro Servidor de Correo
                destinatario = lines[lines.length - 1];
                destinatario = destinatario.split("<")[1].split(">")[0];
            }
        }
        return destinatario;
    }

    public static String getMensaje(String contenido) {
        String orden = "";
        String mensaje = "";
        // Dividir en lineas
        String[] lines = contenido.split("\n");
        int index = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 8 && lines[i].substring(0, 8).toUpperCase().equals("SUBJECT:")) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            // Quitar la palabra 'Subject: '
            orden = lines[index].substring(8);
            mensaje = lines[index];
        }
        return mensaje;
    }

    public static String getAsunto(String contenido) {
        String orden = "";
        String mensaje = "";
        // Dividir en lineas
        String[] lines = contenido.split("\n");
        System.out.println(lines.length);
        int index = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 8 && lines[i].substring(0, 8).toUpperCase().equals("SUBJECT:")) {
                index = i;
                break;
            }
        }
        System.out.println(index);
        if (index > -1) {
            // Quitar la palabra 'Subject: '
            orden = lines[index].substring(9);
            
            System.out.println("orden 222 :" + orden);
            if ("HELP".equals(orden) || 
                    "OBTENEREMPLEADO".equals(orden)  || 
                    "OBTENERCLIENTE".equals(orden) ||
                    "OBTENERFICHAPRODUCCION".equals(orden) || 
                    "OBTENERDETALLECOMPROBANTE".equals(orden) ||
                    "OBTENERCOMPROBANTE".equals(orden)|| 
                    "OBTENERPRODUCTO".equals(orden) ||
                    "OBTENERINSUMO".equals(orden) ||
                    "OBTENERPROVEEDOR".equals(orden) ||
                    "OBTENERDISTRIBUCION".equals(orden) ||
                    "OBTENERPRODUCCION".equals(orden) ||
                    "REPORTEXCLIENTE".equals(orden) ||
                    "REPORTEXPRODUCTO".equals(orden))
                //grupo07sa@ficct.uagrm.edu.bo
                    
            {
                System.out.println("orden entro por que es igual: "+ orden);
                return orden;
            }
            
            if (lines[index].charAt(lines[index].length() - 1) != ']') {
                for (int i = index + 1; i < lines.length; i++) {
                    orden = orden + lines[i].substring(0);
                    if (lines[i].charAt(lines[i].length() - 1) == ']') {
                        break;
                    }
                }
            }
        }
        
        return orden;
    }

    public static String getSubjectOrden(String contenido) {
        System.out.println("contenido : " + contenido);
        String orden = "";
        // Dividir en lineas
        String[] lines = contenido.split("\n");
        int index = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 8 && lines[i].substring(0, 8).toUpperCase().equals("SUBJECT:")) {
                index = i;
                break;
            }
        }

        if (index > -1) {
            // Quitar la palabra 'Subject: '
            orden = lines[index].substring(9);

            System.out.println("orden :" + orden);
            if ("HELP".equals(orden)
                    || "REGISTRARDETALLESERVICIO".equals(orden)
                    || "REGISTRARDETALLECITA".equals(orden)
                    || "PROFORMA".equals(orden)) {
                System.out.println(orden);
                return orden;
            }

            if (lines[index].charAt(lines[index].length() - 1) != ']') {
                for (int i = index + 1; i < lines.length; i++) {
                    orden = orden + lines[i].substring(0);
                    if (lines[i].charAt(lines[i].length() - 1) == ']') {
                        break;
                    }
                }
            }
        }
        System.out.println("orden:  " + orden);
        return orden;
    }

    public static String dibujarTabla(DefaultTableModel tabla) {
        String tableString = "";
        ArrayList<String> headers = new ArrayList<>();
        ArrayList<List<String>> rowList = new ArrayList<>();

        // Agregando Los Headers
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            headers.add(tabla.getColumnName(i));
        }

        // Agregando Content
        for (int i = 0; i < tabla.getRowCount(); i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                row.add(String.valueOf(tabla.getValueAt(i, j)));
            }
            rowList.add(row.subList(0, row.size()));
        }

        if (rowList.size() < 1) {
            return "(Tabla Vacia)";
        }
        /**
         *
         */
        // Creando Tabla para mostrar
        Board board = new Board(125);
        Table table = new Table(board, 125, headers, rowList);
        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        tableString = board.getPreview();

        return tableString;
    }

    public static String quitarComillas(String texto) {
        int len = texto.length() - 1;
        return texto.substring(1, len);
    }

    public static String pruebaHTMl() {
        StringBuffer sb = new StringBuffer();
        sb.append("<table width='100%' border='1'>\r\n"
                + "<tr>\r\n"
                + "<td>Código cliente</td>"
                + "<td>Nome</td>"
                + "<td>Email</td>"
                + "</tr>\r\n");
        sb.append("</table>");
        return sb.toString();
    }
    //-------------------REPORTE CLIENTE PANADERIA--------------------
    public static String dibujarTablaREPORTEPRODUCTOConHTML(List<ReporteProducto> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>NOMBRE</th> \n"
                + "<th>PRECIO</th> \n"
                + "<th>STOCK</th> \n"
                + "<th>TOTAL</th> \n"
                + "</tr> \n"
                + "</thead> \n";
        
        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (lista.get(i).getNombre())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getPrecio())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getStock())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTotal())
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";
        

        return tableString;
    }
    //-------------------REPORTE CLIENTE PANADERIA--------------------
    public static String dibujarTablaREPORTECLIENTEConHTML(List<ReporteCliente> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>NOMBRE</th> \n"
                + "<th>DIRECCION</th> \n"
                + "<th>TELEFONO</th> \n"
                + "<th>EMAIL</th> \n"
                + "<th>TOTAL</th> \n"
                + "</tr> \n"
                + "</thead> \n";
        
        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (lista.get(i).getNombre())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getDireccion())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTelefono())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getEmail())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTotal())
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";
        

        return tableString;
    }
    //-------------------CLIENTE PANADERIA--------------------
    public static String dibujarTablaCLIENTEConHTML(List<Cliente> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>NOMBRE</th> \n"
                + "<th>APELLIDO</th> \n"
                + "<th>DIRECCION</th> \n"
                + "<th>TELEFONO</th> \n"
                + "<th>EMAIL</th> \n"
                + "</tr> \n"
                + "</thead> \n";
        
        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (lista.get(i).getNombre())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getApellido())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getDireccion())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTelefono())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getEmail())
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";
        

        return tableString;
    }
    

  //-----------------------PANADERIA ASISTENCIA---------------
     public static String dibujarTablaFICHAPRODUCCIONConHTML(List<FichaProduccion> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>CANTIDAD</th> \n"
                + "<th>FECHA DE PRODUCCION</th> \n"
                + "<th>TIPO DE PAN</th> \n"
                + "<th>PRODUCCION</th> \n"
                + "<th>INSUMOS</th> \n"
                + "</tr> \n"
                + "</thead> \n";

        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (String.valueOf(lista.get(i).getCantidad()))
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getFecha())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTipopan())
                    + "</td>"
                     + "<td>"
                    + (String.valueOf(lista.get(i).getId_produccion()))
                    + "</td>"
                     + "<td>"
                    + (String.valueOf(lista.get(i).getId_insumo()))
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";

        return tableString;
    }

   //------------------DETALLECOMPROBANTE PANADERIA-----------------------------
        public static String dibujarTablaDETALLECOMPROBANTEConHTML(List<Detallecomprbante> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>CANTIDAD</th> \n"
                + "<th>TOTAL</th> \n"
                + "<th>PRODUCTO</th> \n"
                + "<th>COMPROBANTE</th> \n"
                + "<th>CODIGO DE DISTRIBUCION</th> \n"
                + "</tr> \n"
                + "</thead> \n";

        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (String.valueOf(lista.get(i).getCantidad()))
                    + "</td>"
                    + "<td>"
                    + (Float.toString(lista.get(i).getSubtotal()))
                    + "</td>"
                    + "<td>"
                    + (String.valueOf(lista.get(i).getId_producto()))
                    + "</td>"
                    + "<td>"
                    + (String.valueOf(lista.get(i).getId_comprobante()))
                    + "</td>"
                     + "<td>"
                    + (String.valueOf(lista.get(i).getId_distribucion()))
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";

        return tableString;
    }

   //---------------COMPROBANTE PANADERIA------------------------
        public static String dibujarTablaCOMPROBANTEConHTML(List<Comprobante> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>FECHA</th> \n"
                + "<th>ESTADO</th> \n"
                + "<th>CLIENTE</th> \n"
                + "<th>EMPLEADO</th> \n"
                + "</tr> \n"
                + "</thead> \n";

        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (lista.get(i).getFecha_compra())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getEstado())
                    + "</td>"
                    + "<td>"
                    + (String.valueOf(lista.get(i).getId_cliente()))
                    + "</td>"
                    + "<td>"
                     + (String.valueOf(lista.get(i).getId_empleado()))
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";

        return tableString;
    }
        
        //--------TABLA PRODUCTO PANADERIA -------------------------
         public static String dibujarTablaPRODUCTOConHTML(List<Producto> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>NOMBRE</th> \n"
                + "<th>PRECIO</th> \n"
                + "<th>STOCK</th> \n"
                + "<th>TIPO DE PRODUCTO</th> \n"
                + "</tr> \n"
                + "</thead> \n";

        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (lista.get(i).getNombre())
                    + "</td>"
                    + "<td>"
                    + (Float.toString(lista.get(i).getPrecio()))
                    + "</td>"
                    + "<td>"
                    + (String.valueOf(lista.get(i).getStock()))
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTipoproducto())
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";

        return tableString;
    }
     //---------SERVICIO----------------------
public static String dibujarTablaINSUMOConHTML(List<Insumo> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>NOMBRE</th> \n"
                + "<th>CANTIDAD EN KG.</th> \n"
                + "<th>FECHA COMPRA</th> \n"
                + "<th>PRECIO EN BS.</th> \n"
                + "<th>PROVEEDOR</th> \n"
                + "</tr> \n"
                + "</thead> \n";
        
        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (lista.get(i).getNombre())
                    + "</td>"
                    + "<td>"
                    + (String.valueOf(lista.get(i).getCantidadinsumo()))
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getFecha_compra())
                    + "</td>"
                    + "<td>"
                    + (Float.toString(lista.get(i).getPrecio()))
                    + "</td>"
                      + "<td>"
                    + (String.valueOf(lista.get(i).getId_proveedor()))
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";
        

        return tableString;
    }
 //---------------TRANSACCION-------------------------------
 public static String dibujarTablaPRODUCCIONConHTML(List<Produccion> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>FECCHA DE PRODUCCION</th> \n"
                + "<th>ESTADO</th> \n"
                + "<th>TIPO</th> \n"
                + "<th>EMPLEADO</th> \n"
                + "</tr> \n"
                + "</thead> \n";

        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (lista.get(i).getFecha_produccion())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getEstado())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTipo())
                    + "</td>"
                    + "<td>"
                    + (String.valueOf(lista.get(i).getId_empleado()))
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";

        return tableString;
    }
    //------------TABLA EMPLEADO PANADERIA------------------
    public static String dibujarTablaEMPLEADOConHTML(List<Empleado> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>NOMBRE</th> \n"
                + "<th>APELLIDO</th> \n"
                + "<th>DIRECCION</th> \n"
                + "<th>TELEFONO</th> \n"
                + "<th>TIPO</th> \n"
                + "</tr> \n"
                + "</thead> \n";

        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (lista.get(i).getNombre())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getApellido())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getDireccion())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTelefono())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTipo())
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";

        return tableString;
    }
    
     //------------TABLA PROVEEDOR EMPLEADO------------------
    public static String dibujarTablaPROVEEDORConHTML(List<Proveedor> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>NOMBRE</th> \n"
                + "<th>DIRECCION</th> \n"
                + "<th>TELEFONO</th> \n"
                + "</tr> \n"
                + "</thead> \n";

        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (lista.get(i).getNombre())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getDireccion())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTelefono())
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";

        return tableString;
    }

      public static String dibujarTablaDISTRIBUCIONConHTML(List<Distribucion> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
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
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n"
                + "<th>ID</th> \n"
                + "<th>TIPO DE DISTRIBUCION</th> \n"
                + "<th>TIPO DE TRANSPORTE</th> \n"
                + "<th>DESCRIPCION</th> \n"
                + "</tr> \n"
                + "</thead> \n";

        for (int i = 0; i < lista.size(); i++) {
            tableString += "<tr> \n";
            tableString += "<td>"
                    + (String.valueOf(lista.get(i).getId()))
                    + "</td> \n"
                    + "<td>"
                    + (lista.get(i).getTipodistribucion())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getTipotransporte())
                    + "</td>"
                    + "<td>"
                    + (lista.get(i).getDescripcion())
                    + "</td>"
                    + "</tr> \n";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";

        return tableString;
    }
    //--------reporte asistencia----------------------
  /*  public static String dibujarTablaREPORTEASISTENCIAConHTML(List<ReporteAsistencia> lista) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
                + "<head>\n"
                + "<style>\n"
                + ".button {\n"
               // + "    background-color: #4CAF50; /* Green \n"
             //   + "    border: none;\n"
              //  + "    color: white;\n"
               // + "    padding: 15px 32px;\n"
                //+ "    text-align: center;\n"
               // + "    text-decoration: none;\n"
               // + "    display: inline-block;\n"
                //+ "    font-size: 16px;\n"
                //+ "    margin: 4px 2px;\n"
               // + "    cursor: pointer;\n"
                //+ "}\n"
                //+ "\n"
                //+ ".button2 {background-color: #008CBA;} /* Blue *"
                //+ ".button3 {background-color: #f44336;} /* Red */ //\n"
               // + ".button4 {background-color: #e7e7e7; color: black;} /* Gray */ \n"
                //+ ".button5 {background-color: #555555;} /* Black */"
                //+ "table {\n"
                //+ "    border-collapse: collapse;\n"
                //+ "    width: 100%;\n"
                //+ "}\n"
                //+ "\n"
                //+ "th, td {\n"
                //+ "    text-align: left;\n"
                //+ "    padding: 8px;\n"
                //+ "}\n"
                //+ "\n"
               // + "tr:nth-child(even){background-color: #f2f2f2}\n"
                //+ "\n"
                //+ "th {\n"
                //+ "    background-color: #4CAF50;\n"
                //+ "    color: white;\n"
                //+ "}\n"
                //+ "</style>\n"
                //+ "</head>\n"
               // + "<body>\n"
                //+ "<div class=\"w3-container\">\n"
                //+ "\n"
                //+ "  <table class=\"w3-table-all\">\n"
                //+ "    <thead>\n"
                //+ "<tr class=\"w3-red\">\n"
                //+ "<th>faltas</th> \n"
                //+ "<th>NOMBRE del socio</th> \n"
               // + "</tr> \n"
                //+ "</thead> \n";

        //for (int i = 0; i < lista.size(); i++) {
          //  tableString += "<tr> \n";
            //tableString += "<td>"
              //     + (lista.get(i).getNombre())
                //    + "</td> \n"
                  //  + "<td>"
             
                    //+ (lista.get(i).getFecha_fin())
                   // + "</td>"
                    //+ "<td>"
                    //+ (lista.get(i).getDescripcion())
                    //+ "</td>"
                    //+ "</tr> \n";
       // }
        //tableString += "</table>\n"
          //      + "</div>\n"
            //    + "\n"
              //  + "</body>\n"
                //+ "</html> ";

        //return tableString;
    //}
         
  //------------AULA VIRTUAL-------------------
      
}
