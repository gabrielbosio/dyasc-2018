package ar.edu.untref.dyasc;

import java.awt.Point;

public class Navio {

    private int vidas;
    private Point posicion;
    private boolean[] zonasAtacadas;

    public Navio(int vidas, int x, int y) {
        this.vidas = vidas;
        this.posicion = new Point(x, y);
        zonasAtacadas = new boolean[vidas];
    }
    
    public Resultado daniar(int x, int y) {
        int xRelativo = x - posicionX();
        boolean zonaYaFueAtacada = zonasAtacadas[xRelativo]; 
        Resultado resultado = Resultado.AGUA;
        
        if (!zonaYaFueAtacada) {
            zonasAtacadas[xRelativo] = true;
            vidas--;
            resultado = Resultado.TOCADO;

            if (vidas == 0) {
                resultado = Resultado.HUNDIDO;
            }
        }
        
        return resultado;
    }

    public int vidas() {
        return vidas;
    }

    public int posicionX() {
        return posicion.x;
    }

    public int posicionY() {
        return posicion.y;
    }
}
