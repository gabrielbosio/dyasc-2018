package ar.edu.untref.dyasc.modos;

import ar.edu.untref.dyasc.opciones.Direccion;
import ar.edu.untref.dyasc.opciones.Opcion;
import ar.edu.untref.dyasc.opciones.OpcionNoValidaException;
import ar.edu.untref.dyasc.opciones.Orientacion;

public class ModoDeLista implements ModoDeFuncionamiento {

    @Override
    public String ejecutar(int[] sucesion, String nombreDeOpcion)
            throws OpcionNoValidaException {
        
        Opcion opcion = new Opcion(nombreDeOpcion);
        Orientacion orientacion = opcion.obtenerOrientacion();
        Direccion direccion = opcion.obtenerDireccion();
        boolean esVertical = orientacion == Orientacion.VERTICAL;
        boolean invertida = direccion == Direccion.INVERSA;
        String lista = generarLista(sucesion, esVertical, invertida);
        
        return lista;
    }
    
    private String generarLista(int[] valores, boolean esVertical, boolean invertida) {
        String sucesion = "";
        String separador;
        
        if (esVertical) {
            separador = "\n";
            
        } else {
            separador = " ";
        }
        
        for (int i = 0; i < valores.length; i++) {
            int indice;
            
            if (invertida) {
                indice = valores.length - i - 1;
                
            } else {
                indice = i;
            }
            
            sucesion += separador + valores[indice];
        }
        
        return sucesion;
    }
}
