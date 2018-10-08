package tablero;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.Coordenada;

public class Tablero {

    private Map<Point, Navio> mapaDeNavios;
    private int longitudDeLado;

    public Tablero(int longitudDeLado) {
        mapaDeNavios = new HashMap<>();
        this.longitudDeLado = longitudDeLado;
    }

    public Resultado dispararEn(int x, int y) {

        if (x > longitudDeLado || y > longitudDeLado) {
            throw new AtaqueFueraDelTableroException();
        }

        Navio victima = mapaDeNavios.get(new Point(x, y));
        Resultado resultado = Resultado.AGUA;

        if (victima != null) {
            resultado = victima.daniar(x, y);
        }

        return resultado;
    }

    public void agregar(Navio navio) throws NavioFueraDeTableroException, CasilleroYaOcupadoException {
        int posicionX = navio.posicionX();
        int posicionY = navio.posicionY();

        if (posicionX > longitudDeLado || posicionY > longitudDeLado) {
            throw new NavioFueraDeTableroException();
        }

        if (navio.direccion() == Direccion.HORIZONTAL) {

            for (int i = 0; i < navio.vidas(); i++) {
                chequearCasillero(posicionX, posicionY, i, 0);
            }

            for (int i = 0; i < navio.vidas(); i++) {
                ocuparCasillero(navio, posicionX, posicionY, i, 0);
            }

        } else if (navio.direccion() == Direccion.VERTICAL) {

            for (int i = 0; i < navio.vidas(); i++) {
                chequearCasillero(posicionX, posicionY, 0, i);
            }

            for (int i = 0; i < navio.vidas(); i++) {
                ocuparCasillero(navio, posicionX, posicionY, 0, i);
            }
        }
    }

    private void chequearCasillero(int posicionX, int posicionY, int desplazamientoX, int desplazamientoY)
            throws CasilleroYaOcupadoException {

        int posicionDesplazadaX = posicionX + desplazamientoX;
        int posicionDesplazadaY = posicionY + desplazamientoY;
        Point posicionDesplazada;
        Navio navioEnConflicto;

        if (posicionDesplazadaX > longitudDeLado || posicionDesplazadaY > longitudDeLado) {
            throw new NavioFueraDeTableroException();
        }

        posicionDesplazada = new Point(posicionDesplazadaX, posicionDesplazadaY);
        navioEnConflicto = mapaDeNavios.get(posicionDesplazada);

        if (navioEnConflicto != null) {
            throw new CasilleroYaOcupadoException();
        }
    }

    private void ocuparCasillero(Navio navio, int posicionX, int posicionY, int desplazamientoX, int desplazamientoY) {
        int posicionDesplazadaX = posicionX + desplazamientoX;
        int posicionDesplazadaY = posicionY + desplazamientoY;
        Point posicionDesplazada = new Point(posicionDesplazadaX, posicionDesplazadaY);
        mapaDeNavios.put(posicionDesplazada, navio);
    }

    public Resultado dispararEn(Coordenada coordenada) {
        return dispararEn(coordenada.x(), coordenada.y());
    }

}
