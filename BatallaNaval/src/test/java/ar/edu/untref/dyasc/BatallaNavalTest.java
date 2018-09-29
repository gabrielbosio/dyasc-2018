package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class BatallaNavalTest {
	
	@Test
	public void alAtacarEnUnCasilleroDeUnTableroDeUnSoloCasilleroVacioDisparoEnAgua() throws AtaqueFueraDelTableroException {
		Tablero tablero = new Tablero(1, 1);
		
		Resultado resultadoDeAtaque = tablero.atacarEn(1, 1);
		
		Assert.assertEquals(Resultado.AGUA, resultadoDeAtaque);
	}
	
	@Test
	public void elTableroDeUnCasilleroTieneUnBoteYLoAtacoYObtengoUnHundido() throws AtaqueFueraDelTableroException {
		Tablero tablero = new Tablero(1, 1);
		tablero.agregar(1, 1, new Bote());
		
		Resultado resultadoDeAtaque = tablero.atacarEn(1, 1);
		
		Assert.assertEquals(Resultado.HUNDIDO, resultadoDeAtaque);
	}
	
	@Test
	public void elTableroDeCuatroCasillerosTieneDosBotesYAtacoTodosLosCasillerosYObtengoDosAguaYDosHundido() throws AtaqueFueraDelTableroException {
		Tablero tablero = new Tablero(2, 2);
		tablero.agregar(1, 1, new Bote());
		tablero.agregar(2, 2, new Bote());
		
		Resultado resultadoFila1Columna1 = tablero.atacarEn(1, 1);
		Resultado resultadoFila1Columna2 = tablero.atacarEn(1, 2);
		Resultado resultadoFila2Columna1 = tablero.atacarEn(2, 1);
		Resultado resultadoFila2Columna2 = tablero.atacarEn(2, 2);
		
		Assert.assertEquals(Resultado.HUNDIDO, resultadoFila1Columna1);
		Assert.assertEquals(Resultado.AGUA, resultadoFila1Columna2);
		Assert.assertEquals(Resultado.AGUA, resultadoFila2Columna1);
		Assert.assertEquals(Resultado.HUNDIDO, resultadoFila2Columna2);
	}
	
	@Test(expected = AtaqueFueraDelTableroException.class)
	public void seIntentaAtacarFueraDelTablero() throws AtaqueFueraDelTableroException {
		Tablero tablero = new Tablero(4, 4);
		
		tablero.atacarEn(5, 2);
	}
}
