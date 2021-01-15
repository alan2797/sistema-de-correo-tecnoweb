/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Franklin
 */
public class Utility {
    
    public static String tableOf(Object obj){
        return obj.getClass().getSimpleName().toLowerCase();//+"s"
    }
    public static List<Field> getFields(Method[] methods, Object invoker, boolean request){
        List<Field> fields = new ArrayList<>();
        try {
            for (int i = methods.length - 1; i >= 0; i--) {
                if (methods[i].getName().contains("get")) {
                    String name = toFieldName(methods[i].getName());
                    Object value = methods[i].invoke(invoker,(Object[]) null);
                    Class<?> type = methods[i].getReturnType();
                    if (request || value != null) {
                        fields.add(new Field(name, value, type.getSimpleName()));
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, "Failed to get name of fields", e);
        }
        return fields;
    }
   //elimina el prefijo get
    private static String toFieldName(String getterMethod) {
        char[] field = getterMethod.substring(3).toCharArray();
        field[0]= getterMethod.toLowerCase().charAt(3);
        return new String(field).toLowerCase();
    }
    
}