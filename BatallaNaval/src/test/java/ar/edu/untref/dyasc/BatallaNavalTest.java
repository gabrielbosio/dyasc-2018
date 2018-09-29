package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class BatallaNavalTest {

    @Test
    public void alAtacarEnUnCasilleroDeUnTableroDeUnSoloCasilleroVacioDisparoEnAgua() {
        Tablero tablero = new Tablero(1);

        Resultado resultadoDeAtaque = tablero.atacarEn(1, 1);

        Assert.assertEquals(Resultado.AGUA, resultadoDeAtaque);
    }

    @Test
    public void elTableroDeUnCasilleroTieneUnBoteYLoAtacoYObtengoUnHundido()
            throws NavioFueraDeTableroException {
        
        Tablero tablero = new Tablero(1);
        tablero.agregar(FabricaDeNavios.crearBote(1, 1));

        Resultado resultadoDeAtaque = tablero.atacarEn(1, 1);

        Assert.assertEquals(Resultado.HUNDIDO, resultadoDeAtaque);
    }

    @Test
    public void elTableroDeCuatroCasillerosTieneDosBotesYAtacoTodosLosCasillerosYObtengoDosAguaYDosHundido()
            throws NavioFueraDeTableroException {

        Tablero tablero = new Tablero(2);
        tablero.agregar(FabricaDeNavios.crearBote(1, 1));
        tablero.agregar(FabricaDeNavios.crearBote(2, 2));

        Resultado resultadoEnX1Y1 = tablero.atacarEn(1, 1);
        Resultado resultadoEnX1Y2 = tablero.atacarEn(1, 2);
        Resultado resultadoEnX2Y1 = tablero.atacarEn(2, 1);
        Resultado resultadoEnX2Y2 = tablero.atacarEn(2, 2);

        Assert.assertEquals(Resultado.HUNDIDO, resultadoEnX1Y1);
        Assert.assertEquals(Resultado.AGUA, resultadoEnX1Y2);
        Assert.assertEquals(Resultado.AGUA, resultadoEnX2Y1);
        Assert.assertEquals(Resultado.HUNDIDO, resultadoEnX2Y2);
    }

    @Test(expected = AtaqueFueraDelTableroException.class)
    public void seIntentaAtacarFueraDelTablero() {
        Tablero tablero = new Tablero(4);

        tablero.atacarEn(5, 2);
    }

    @Test
    public void elCruceroEntraJustoDeFormaHorizontalEnElTableroYLoAtacoHastaHundirlo()
            throws NavioFueraDeTableroException {

        Tablero tablero = new Tablero(3);
        tablero.agregar(FabricaDeNavios.crearCrucero(1, 1, Direccion.HORIZONTAL));

        Resultado resultadoLadoOesteDeCrucero = tablero.atacarEn(1, 1);
        Resultado resultadoCentroDeCrucero = tablero.atacarEn(2, 1);
        Resultado resultadoLadoEsteDeCrucero = tablero.atacarEn(3, 1);

        Assert.assertEquals(Resultado.TOCADO, resultadoLadoOesteDeCrucero);
        Assert.assertEquals(Resultado.TOCADO, resultadoCentroDeCrucero);
        Assert.assertEquals(Resultado.HUNDIDO, resultadoLadoEsteDeCrucero);
    }

    @Test
    public void atacoHastaHundirloAUnCruceroColocadoDeFormaVerticalEnElTablero()
            throws NavioFueraDeTableroException {
        
        Tablero tablero = new Tablero(3);
        tablero.agregar(FabricaDeNavios.crearCrucero(1, 1, Direccion.VERTICAL));

        Resultado resultadoLadoNorteDeCrucero = tablero.atacarEn(1, 1);
        Resultado resultadoCentroDeCrucero = tablero.atacarEn(1, 2);
        Resultado resultadoLadoSurDeCrucero = tablero.atacarEn(1, 3);

        Assert.assertEquals(Resultado.TOCADO, resultadoLadoNorteDeCrucero);
        Assert.assertEquals(Resultado.TOCADO, resultadoCentroDeCrucero);
        Assert.assertEquals(Resultado.HUNDIDO, resultadoLadoSurDeCrucero);
    }

    @Test(expected = NavioFueraDeTableroException.class)
    public void intentoAgregarUnBoteFueraDelTablero()  {
        Tablero tablero = new Tablero(2);

        tablero.agregar(FabricaDeNavios.crearBote(3, 1));
    }
    
    @Test(expected = NavioFueraDeTableroException.class)
    public void intentoAgregarUnCruceroParcialmenteFueraDelTablero() {
        Tablero tablero = new Tablero(4);
        
        tablero.agregar(FabricaDeNavios.crearCrucero(3, 1, Direccion.HORIZONTAL));
    }
}
