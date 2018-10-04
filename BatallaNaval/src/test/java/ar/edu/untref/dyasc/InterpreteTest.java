package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class InterpreteTest {
    
    @Test
    public void ingresoLasCoordenadasAUnoEnMinusculaTodoJuntoYObtengoElParUnoUno() {
        String entrada = "a1";
        
        Coordenada salidaActual = Interprete.procesar(entrada);
        Coordenada salidaEsperada = new Coordenada(1, 1);
        
        Assert.assertEquals(salidaEsperada, salidaActual);
    }
}
