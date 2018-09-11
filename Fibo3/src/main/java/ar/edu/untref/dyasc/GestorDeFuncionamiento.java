package ar.edu.untref.dyasc;

import java.util.HashMap;

import ar.edu.untref.dyasc.modos.ModoDeFuncionamiento;
import ar.edu.untref.dyasc.opciones.OpcionNoValidaException;

public class GestorDeFuncionamiento {
    private HashMap<String, ModoDeFuncionamiento> modos;
    private String nombrePredeterminado;
    
    public GestorDeFuncionamiento() {
        modos = new HashMap<>();        
    }
    
    public void agregarModo(String nombre, ModoDeFuncionamiento modo,
            boolean esPredeterminado) {
        
        modos.put(nombre, modo);
        
        if (esPredeterminado) {
            nombrePredeterminado = nombre;
        }
    }
    
    public void agregarModo(String nombre, ModoDeFuncionamiento modo) {
        agregarModo(nombre, modo, false);
    }
    
    public String ejecutarFuncion(int[] sucesion, String opcion, String idModo)
            throws OpcionNoValidaException {
        
        String salida;
        String nombreDeModo;
        ModoDeFuncionamiento modo;
        
        if (idModo == null) {
            nombreDeModo = nombrePredeterminado;
        
        } else {
            nombreDeModo = idModo;
        }
        
        modo = modos.get(nombreDeModo);
        salida = modo.ejecutar(sucesion, opcion);
        
        return salida;
    }
}
