package ar.edu.untref.dyasc;

public class Ejemplo {

    public static void main(String[] args) {
        Bitacora bitacora = Bitacora.obtenerInstancia();
        
        bitacora.registrarEvento("Iniciando ejecucion");
        bitacora.registrarEvento("Archivo guardado");            
        bitacora.registrarEvento("Finalizando ejecucion");
    }
}
