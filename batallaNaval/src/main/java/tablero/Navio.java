package tablero;

import java.awt.Point;

public class Navio {

    private int vidas;
    private Point posicion;
    private boolean[] zonasAtacadas;
    private Direccion direccion;

    public Navio(int vidas, int x, int y, Direccion direccion) {
        this.vidas = vidas;
        this.posicion = new Point(x, y);
        this.direccion = direccion;
        zonasAtacadas = new boolean[vidas];
    }

    public Resultado daniar(int x, int y) {
        int zona = x - posicionX();
        boolean zonaYaFueAtacada;
        Resultado resultado;

        if (direccion() == Direccion.VERTICAL) {
            zona = y - posicionY();
        }

        zonaYaFueAtacada = zonasAtacadas[zona];
        resultado = Resultado.AGUA;

        if (!zonaYaFueAtacada) {
            zonasAtacadas[zona] = true;
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

    public Direccion direccion() {
        return direccion;
    }

}
