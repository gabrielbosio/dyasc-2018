package ar.edu.untref.dyasc;

import java.io.IOException;
import ar.edu.untref.dyasc.opciones.OpcionNoValidaException;

public class Main {
    
    public static void main(String[] args) {
        ProcesoFibonacci proceso = new ProcesoFibonacci();
        Parser parser = new Parser(args);
        int longitud = Integer.parseInt(parser.obtenerArgumentoObligatorio());
        String opcion = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_OPCION);
        String idModo = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_MODO);
        String ruta = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_SALIDA);
        
        try {
            String salida = proceso.ejecutar(opcion, idModo, longitud, ruta);
            System.out.println(salida);
            
        } catch (OpcionNoValidaException e) {
            System.out.println("Opciones no válidas.");
            
        } catch (IOException e) {
            System.out.println("No se pudo guardar en el archivo " + ruta);
        }
    }
}
