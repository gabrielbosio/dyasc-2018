package ar.edu.untref.dyasc.opciones;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.Configuracion;

public class Opcion {
    private Orientacion orientacion;
    private Direccion direccion;
    private static Map<String, Orientacion> mapaDeOrientaciones = new HashMap<>();
    private static Map<String, Direccion> mapaDeDirecciones = new HashMap<>();
    
    static {
        mapaDeOrientaciones.put(Configuracion.ORIENTACION_HORIZONTAL, Orientacion.HORIZONTAL);
        mapaDeOrientaciones.put(Configuracion.ORIENTACION_VERTICAL, Orientacion.VERTICAL);
        mapaDeDirecciones.put(Configuracion.DIRECCION_DIRECTA, Direccion.DIRECTA);
        mapaDeDirecciones.put(Configuracion.DIRECCION_INVERSA, Direccion.INVERSA);
    }
    
    public Opcion(String cadena) throws OpcionNoValidaException {
        String valorDeOpcion;
        
        if (cadena == null) {
            valorDeOpcion = Configuracion.OPCION_PREDETERMINADA;
            
        } else {
            valorDeOpcion = cadena;
        }
        
        String caracterDeOrientacion = valorDeOpcion.substring(0, 1);
        String caracterDeDireccion = valorDeOpcion.substring(1);
        orientacion = mapaDeOrientaciones.get(caracterDeOrientacion);
        direccion = mapaDeDirecciones.get(caracterDeDireccion);
        
        if (orientacion == null || direccion == null) {
            throw new OpcionNoValidaException();
        }
    }
    
    public Orientacion obtenerOrientacion() {
        return orientacion;
    }
    
    public Direccion obtenerDireccion() {
        return direccion;
    }
}
