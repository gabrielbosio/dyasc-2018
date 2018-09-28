package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class BatallaNavalTest {
	
	@Test
	public void alAtacarEnUnCasilleroDeUnTableroVacioDisparoEnAgua() {
		Tablero tablero = new Tablero(8, 8);
		
		Resultado resultadoFila2Columna2 = tablero.atacarEn(2, 2);
		
		Assert.assertEquals(Resultado.AGUA, resultadoFila2Columna2);
	}
}
