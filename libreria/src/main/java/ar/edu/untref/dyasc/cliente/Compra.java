package ar.edu.untref.dyasc.cliente;

import ar.edu.untref.dyasc.Configuracion;
import ar.edu.untref.dyasc.productos.Producto;

public class Compra {
    private Producto producto;
    private int mes;
    private int anio;

    public Compra(Producto producto, int mes, int anio) {
        this.producto = producto;
        this.mes = mes;
        this.anio = anio;
    }
    
    public int obtenerMes() {
        return mes;
    }
    
    public int obtenerAnio() {
        return anio;
    }
    
    public float obtenerPrecio() {
        return producto.obtenerTotal();
    }

    public float obtenerTotal() {
        return obtenerPrecio() * (1 - Configuracion.DESCUENTO_CLIENTE_REGISTRADO);
    }
    
    public boolean debePagarse(int mes, int anio) {
        int mesDeCompra = obtenerMes();
        int anioDeCompra = obtenerAnio();
        
        return mesDeCompra == mes && anioDeCompra == anio;
    }
}
