package ar.edu.untref.dyasc.modos;

import ar.edu.untref.dyasc.opciones.OpcionNoValidaException;

public interface ModoDeFuncionamiento {
    
    public String ejecutar(int[] sucesion, String nombreDeOpcion)
            throws OpcionNoValidaException;
}
