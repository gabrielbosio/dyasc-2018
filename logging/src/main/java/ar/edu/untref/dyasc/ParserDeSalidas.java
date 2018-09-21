package ar.edu.untref.dyasc;

public class ParserDeSalidas {
    
    public static Salida[] parsear(String entrada) {
        String[] opciones = entrada.split(",");
        Salida[] resultado = new Salida[opciones.length];
        
        for (int i = 0; i < opciones.length; i++) {
            String opcion = opciones[i];
            
            switch (opcion) {
                
            case "CONSOLA":
                resultado[i] = new SalidaPorConsola();
                
                break;
                
            case "ARCHIVO":
                resultado[i] = new SalidaPorArchivo("bitacora.txt");
                
                break;
                
            default:
                resultado[i] = new SalidaPorArchivo(opcion);
                
                break;
            }
        }
        
        return resultado;
    }
}
