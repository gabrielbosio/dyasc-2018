package ar.edu.untref.dyasc;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Tablero {

    private Map<Point, Navio> barcos;
    private int longitudDeLado;

    public Tablero(int longitudDeLado) {
        barcos = new HashMap<>();
        this.longitudDeLado = longitudDeLado;
    }

    public Resultado atacarEn(int x, int y) throws AtaqueFueraDelTableroException {

        if (x > longitudDeLado || y > longitudDeLado) {
            throw new AtaqueFueraDelTableroException();
        }

        Navio victima = barcos.get(new Point(x, y));
        Resultado resultado = Resultado.AGUA;

        if (victima != null) {
            resultado = victima.daniar(x, y);
        }

        return resultado;
    }

    public void agregar(Navio navio) throws NavioFueraDeTableroException {
        int posicionX = navio.posicionX();
        int posicionY = navio.posicionY();

        if (posicionX > longitudDeLado || posicionY > longitudDeLado) {
            throw new NavioFueraDeTableroException();
        }
        
        if (navio.direccion() == Direccion.HORIZONTAL) {

            for (int i = 0; i < navio.vidas(); i++) {
                int posicionDesplazadaX = posicionX + i;
                
                if (posicionDesplazadaX > longitudDeLado) {
                    throw new NavioFueraDeTableroException();
                }
                
                barcos.put(new Point(posicionDesplazadaX, posicionY), navio);
            }

        } else if (navio.direccion() == Direccion.VERTICAL) {

            for (int i = 0; i < navio.vidas(); i++) {
                int posicionDesplazadaY = posicionY + i;
                
                if (posicionDesplazadaY > longitudDeLado) {
                    throw new NavioFueraDeTableroException();
                }
                
                barcos.put(new Point(posicionX, posicionDesplazadaY), navio);
            }
        }
    }

}
