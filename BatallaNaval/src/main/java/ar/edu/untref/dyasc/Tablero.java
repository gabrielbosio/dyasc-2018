package ar.edu.untref.dyasc;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Tablero {

    private Map<Point, Navio> mapaDeNavios;
    private int longitudDeLado;

    public Tablero(int longitudDeLado) {
        mapaDeNavios = new HashMap<>();
        this.longitudDeLado = longitudDeLado;
    }

    public Resultado atacarEn(int x, int y) {

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
                ocuparCasillero(navio, posicionX, posicionY, i, 0);
            }

        } else if (navio.direccion() == Direccion.VERTICAL) {

            for (int i = 0; i < navio.vidas(); i++) {
                ocuparCasillero(navio, posicionX, posicionY, 0, i);
            }
        }
    }

    private void ocuparCasillero(Navio navio, int posicionX, int posicionY, int desplazamientoX,
            int desplazamientoY) throws CasilleroYaOcupadoException {
        
        int posicionDesplazadaX = posicionX + desplazamientoX;
        int posicionDesplazadaY = posicionY + desplazamientoY;
        Point posicionDesplazada;
        Navio navioEnConflicto;
        
        if (posicionDesplazadaX > longitudDeLado || posicionDesplazadaY > longitudDeLado) {
            throw new NavioFueraDeTableroException();
        }
        
        posicionDesplazada = new Point(posicionDesplazadaX, posicionDesplazadaY);
        navioEnConflicto = mapaDeNavios.put(posicionDesplazada, navio);
        
        if (navioEnConflicto != null) {
            mapaDeNavios.put(posicionDesplazada, navioEnConflicto);
            throw new CasilleroYaOcupadoException();
        }
    }
    
}
