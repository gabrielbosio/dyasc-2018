package ar.edu.untref.dyasc;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ImpresorDeSalida {

    public boolean imprimir(String entrada, int longitud, String ruta) throws IOException {
        Writer escritor;
        OutputStream destino;
        boolean imprimeEnArchivo = ruta != null && ruta.trim() != "";
        
        if (imprimeEnArchivo) {
            destino = new FileOutputStream(ruta);
            escritor = new BufferedWriter(new OutputStreamWriter(destino));
            escritor.write(entrada);
            escritor.close();
        }
        
        return imprimeEnArchivo;
    }
}
