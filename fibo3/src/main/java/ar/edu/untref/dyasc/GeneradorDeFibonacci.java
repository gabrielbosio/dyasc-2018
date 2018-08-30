package ar.edu.untref.dyasc;

public class GeneradorDeFibonacci {
    
    public int[] generarSucesion(int longitud) {
        int sumando1 = 0;
        int sumando2 = 1;
        int[] valoresDeSucesion = new int[longitud];
        
        for (int i = 0; i < longitud; i++) {
            int temporal = sumando2;
            valoresDeSucesion[i] = sumando1;
            sumando2 += sumando1;
            sumando1 = temporal;
        }
        
        return valoresDeSucesion;
    }
}
