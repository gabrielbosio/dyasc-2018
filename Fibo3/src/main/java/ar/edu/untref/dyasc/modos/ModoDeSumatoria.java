package ar.edu.untref.dyasc.modos;

import ar.edu.untref.dyasc.opciones.Opcion;
import ar.edu.untref.dyasc.opciones.OpcionNoValidaException;
import ar.edu.untref.dyasc.opciones.Orientacion;

public class ModoDeSumatoria implements ModoDeFuncionamiento {

    @Override
    public String ejecutar(int[] sucesion, String nombreDeOpcion)
            throws OpcionNoValidaException {
        
        Opcion opcion = new Opcion(nombreDeOpcion);
        Orientacion orientacion = opcion.obtenerOrientacion();
        boolean esVertical = orientacion == Orientacion.VERTICAL;
        int sumatoria = generarSumatoria(sucesion);
        String inicio;
        String salida;
        
        if (esVertical) {
            inicio = "\n";
            
        } else {
            inicio = " ";
        }
        
        salida = inicio + sumatoria;
        
        return salida;
    }
    
    private int generarSumatoria(int[] sumandos) {
        int resultado = 0;
        
        for (int sumando : sumandos) {
            resultado += sumando;
        }
        
        return resultado;
    }
}
