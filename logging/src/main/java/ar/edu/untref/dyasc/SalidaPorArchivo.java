package ar.edu.untref.dyasc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class SalidaPorArchivo implements Salida {
    private String destino;
    
    public SalidaPorArchivo(String destino) {
        this.destino = destino;
    }
    
    @Override
    public void imprimir(String entrada) {
        
        try {
            Writer escritorDeArchivo = new FileWriter(destino, true);
            Writer escritorConBuffer = new BufferedWriter(escritorDeArchivo);
            PrintWriter escritor = new PrintWriter(escritorConBuffer);
            escritor.println(entrada);
            escritor.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
