package ar.edu.untref.dyasc;

public class Coordenada {

    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;

        if (obj instanceof Coordenada) {
            Coordenada otraCoordenada = (Coordenada) obj;
            resultado = x == otraCoordenada.x && y == otraCoordenada.y;
        }

        return resultado;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
