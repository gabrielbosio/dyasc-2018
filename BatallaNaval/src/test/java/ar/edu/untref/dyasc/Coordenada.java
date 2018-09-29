package ar.edu.untref.dyasc;

import java.awt.Point;

public class Coordenada {
	
	private Point punto;

	public Coordenada(int x, int y) {
		punto = new Point(x, y);
	}
	
	@Override
	public int hashCode() {
		return punto.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return punto.equals(obj);
	}
}
