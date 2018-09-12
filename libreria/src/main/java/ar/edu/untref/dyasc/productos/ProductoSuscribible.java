package ar.edu.untref.dyasc.productos;

public abstract class ProductoSuscribible extends Producto {
    private Periodicidad periodicidad;
    
    public ProductoSuscribible(float precio, Periodicidad periodicidad) {
        super(precio);
        
        this.periodicidad = periodicidad;
    }
    
    public Periodicidad obtenerPeriodicidad() {
        return periodicidad;
    }
}
