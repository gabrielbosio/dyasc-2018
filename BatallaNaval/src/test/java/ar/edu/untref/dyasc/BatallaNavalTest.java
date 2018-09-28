package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class BatallaNavalTest {
	
	@Test
	public void alAtacarEnUnCasilleroDeUnTableroDeUnSoloCasilleroVacioDisparoEnAgua() {
		Tablero tablero = new Tablero(1, 1);
		
		Resultado resultadoDeAtaque = tablero.atacarEn(1, 1);
		
		Assert.assertEquals(Resultado.AGUA, resultadoDeAtaque);
	}
	
	@Test
	public void elTableroDeUnCasilleroTieneUnBoteYLoAtacoYObtengoUnHundido() {
		Tablero tablero = new Tablero(1, 1);
		Resultado resultadoDeAtaque;
		
		tablero.agregar(1, 1, new Bote());
		resultadoDeAtaque = tablero.atacarEn(1, 1);
		
		Assert.assertEquals(Resultado.HUNDIDO, resultadoDeAtaque);
	}
}
