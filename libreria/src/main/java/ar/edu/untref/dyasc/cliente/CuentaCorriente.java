package ar.edu.untref.dyasc.cliente;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.Configuracion;
import ar.edu.untref.dyasc.productos.Producto;
import ar.edu.untref.dyasc.productos.ProductoSuscribible;

public class CuentaCorriente {
    Map<Producto, Compra> compras;
    
    public CuentaCorriente() {
        compras = new HashMap<>();
    }
    
    public void agregarCompra(Producto producto, int mes, int anio) {
        Compra nuevaCompra = new Compra(producto, mes, anio);
        compras.put(producto, nuevaCompra);
    }
    
    public void agregarSuscripcion(ProductoSuscribible producto, int mes, int anio,
            int duracion) {        
        
        Suscripcion nuevaSucripcion = new Suscripcion(producto, mes, anio, duracion);
        compras.put(producto, nuevaSucripcion);
    }
    
    public float obtenerTotal(int mes, int anio) {
        float total = 0;
        
        for (Compra compra : compras.values()) {
            
            if (compra.debePagarse(mes, anio)) {
                total += compra.obtenerTotal();
            }
        }
        
        return total;
    }

    public float obtenerTotal(int anio) {
        float total = 0;
        
        for (Compra compra : compras.values()) {
            
            for (int mes = 1; mes <= Configuracion.MESES_EN_ANIO; mes++) {
                
                if (compra.debePagarse(mes, anio)) {
                    total += compra.obtenerTotal();
                }
            }
        }
        
        return total;
    }
}
