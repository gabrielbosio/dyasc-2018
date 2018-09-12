package ar.edu.untref.dyasc.productos;

public abstract class Producto {
    private float precio;
    
    public Producto(float precio) {
        this.precio = precio;
    }
    
    public float obtenerTotal() {
        return precio;
    }
}
