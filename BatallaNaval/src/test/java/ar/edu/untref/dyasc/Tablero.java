package ar.edu.untref.dyasc;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Tablero {
	
	private Map<Point, Bote> barcos;
	private int ancho;
	private int alto;

	public Tablero(int ancho, int alto) {
		barcos = new HashMap<>();
		this.ancho = ancho;
		this.alto = alto;
	}

	public Resultado atacarEn(int x, int y)
			throws AtaqueFueraDelTableroException {
		
		if (x > ancho || y > alto) {
			throw new AtaqueFueraDelTableroException();
		}
		
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
