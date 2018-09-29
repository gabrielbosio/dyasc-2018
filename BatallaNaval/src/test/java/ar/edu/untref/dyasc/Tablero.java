package ar.edu.untref.dyasc;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Tablero {
	
	private Map<Point, Bote> barcos;

	public Tablero(int ancho, int alto) {
		barcos = new HashMap<>();
	}

	public Resultado atacarEn(int x, int y) {
		Bote victima = barcos.get(new Point(x, y));
		Resultado resultado;
		
		if (victima == null) {
			resultado = Resultado.AGUA;
		
		} else {	
			resultado = victima.atacar();
		}
		
		return resultado;
	}

	public void agregar(int x, int y, Bote bote) {
		barcos.put(new Point(x, y), bote);
	}

}
