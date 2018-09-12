package ar.edu.untref.dyasc.cliente;

import ar.edu.untref.dyasc.Configuracion;
import ar.edu.untref.dyasc.productos.ProductoSuscribible;

public class Suscripcion extends Compra {
    private int duracion;
    private int cantidadPorMes;

    public Suscripcion(ProductoSuscribible producto, int mes, int anio, int duracion) {
        super(producto, mes, anio);
        
        this.duracion = duracion;
        this.cantidadPorMes = producto.obtenerPeriodicidad().enVecesAlMes();
    }
    
    @Override
    public float obtenerTotal() {
        float precioDeProducto;
        float descuento;
        
        if (duracion >= 12) {
            precioDeProducto = obtenerPrecio();
            descuento = Configuracion.DESCUENTO_SUSCRIPCION;
            
        } else {
            precioDeProducto = super.obtenerTotal();
            descuento = 0.0f;
        }
        
        return precioDeProducto * cantidadPorMes * (1 - descuento);
    }
    
    @Override
    public boolean debePagarse(int mes, int anio) {
        int diferenciaDeAniosEnMeses = (anio - obtenerAnio()) * Configuracion.MESES_EN_ANIO;
        int diferenciaDeMeses = mes + diferenciaDeAniosEnMeses - obtenerMes();
        boolean fueCompradoAntes = diferenciaDeAniosEnMeses >= 0 && diferenciaDeMeses >= 0;
        boolean vencioLaSuscripcion = diferenciaDeMeses >= duracion;
        
        return fueCompradoAntes && !vencioLaSuscripcion;
    }
}
