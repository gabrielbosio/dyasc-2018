package ar.edu.untref.dyasc;

public class Tablero {
	
	private Resultado resultado;

	public Tablero(int ancho, int alto) {
		resultado = Resultado.AGUA;
	}

	public Resultado atacarEn(int x, int y) {
		return resultado;
	}

	public void agregar(int x, int y, Bote bote) {
		resultado = Resultado.HUNDIDO;
	}

}
