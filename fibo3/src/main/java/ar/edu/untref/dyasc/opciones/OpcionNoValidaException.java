package ar.edu.untref.dyasc.opciones;

@SuppressWarnings("serial")
public class OpcionNoValidaException extends Exception {
    
    @Override
    public String getMessage() {
        return toString();
    }
    
    @Override
    public String toString() {
        return "Opciones no válidas.";
    }
}
