package ar.edu.untref.dyasc;

public class ResultadoFibonacci {
    private String prefijo;
    private String sucesion;
    private String banderas;
    
    public ResultadoFibonacci(int longitud, String sucesion, String idModo) {
        prefijo = "fibo<" + longitud + ">";
        this.sucesion = sucesion;
        
        if (idModo == null || idModo == Configuracion.MODO_LISTA) {
            banderas = "";
            
        } else {
            banderas = idModo;
        }
    }
    
    public String obtenerPrefijo() {
        return prefijo;
    }

    @Override
    public String toString() {
        return prefijo + banderas + ":" + sucesion;
    }
}
