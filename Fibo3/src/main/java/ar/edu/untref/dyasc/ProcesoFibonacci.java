package ar.edu.untref.dyasc;

import java.io.IOException;

import ar.edu.untref.dyasc.opciones.OpcionNoValidaException;

public class ProcesoFibonacci {
    GeneradorDeFibonacci generador;
    GestorDeFuncionamiento gestor;
    ImpresorDeSalida impresor;
    
    public ProcesoFibonacci() {
        generador = new GeneradorDeFibonacci();
        gestor = new FabricaDeGestores().construirGestor();
        impresor = new ImpresorDeSalida();
    }
    
    public String ejecutar(String opcion, String idModo, int longitud,
            String ruta) throws OpcionNoValidaException, IOException {
        
        int[] sucesion = generador.generarSucesion(longitud);
        String entrada = gestor.ejecutarFuncion(sucesion, opcion, idModo);
        ResultadoFibonacci resultado = new ResultadoFibonacci(longitud, entrada, idModo);
        String salida;
        
        if (impresor.imprimir(resultado.toString(), longitud, ruta)) {
            salida = resultado.obtenerPrefijo() + " guardado en " + ruta;
            
        } else {
            salida = resultado.toString();
        }
        
        return salida;
    }
}
