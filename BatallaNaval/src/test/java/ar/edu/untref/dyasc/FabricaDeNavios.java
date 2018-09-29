package ar.edu.untref.dyasc;

public class FabricaDeNavios {

    public static Navio crearBote(int x, int y) {
        return new Navio(1, x, y, Direccion.HORIZONTAL);
    }

    public static Navio crearCrucero(int x, int y, Direccion direccion) {
        return new Navio(3, x, y, direccion);
    }
}
