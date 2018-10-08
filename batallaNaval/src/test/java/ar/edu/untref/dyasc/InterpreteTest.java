package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import interprete.CaracterInvalidoException;
import interprete.Interprete;
import interprete.LongitudInvalidaException;

public class InterpreteTest {

    @Test
    public void ingresoLasCoordenadasAUnoEnMinusculaTodoJuntoYObtengoElParUnoUno() {
        String entrada = "a1";

        Coordenada salidaActual = Interprete.procesar(entrada);

        Assert.assertEquals(1, salidaActual.x());
        Assert.assertEquals(1, salidaActual.y());
    }

    @Test
    public void conLasCoordenadasADosEnMinusculaTodoJuntoComoEntradaObtengoElParUnoDos() {
        String entrada = "a2";

        Coordenada salidaActual = Interprete.procesar(entrada);

        Assert.assertEquals(1, salidaActual.x());
        Assert.assertEquals(2, salidaActual.y());
    }

    @Test(expected = LongitudInvalidaException.class)
    public void noPuedoIngresarUnaCoordenadaNumericaDeMasDeUnaCifra() {
        String entrada = "a10";

        Interprete.procesar(entrada);
    }

    @Test(expected = CaracterInvalidoException.class)
    public void ingresoUnCaracterQueNoEsLetraYObtengoUnaExcepcion() {
        String entrada = "$5";

        Interprete.procesar(entrada);
    }
    
    @Test(expected = LongitudInvalidaException.class)
    public void noPuedoNoIngresarNada() {
        String entrada = "";
        
        Interprete.procesar(entrada);
    }
}
