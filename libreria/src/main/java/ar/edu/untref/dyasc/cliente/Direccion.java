package ar.edu.untref.dyasc.cliente;

public class Direccion {
    private String calle;
    private int numero;
    private String localidad;

    public Direccion(String calle, int numero, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }

    public String obtenerCalle() {
        return calle;
    }

    public int obtenerNumero() {
        return numero;
    }

    public String obtenerLocalidad() {
        return localidad;
    }
}
