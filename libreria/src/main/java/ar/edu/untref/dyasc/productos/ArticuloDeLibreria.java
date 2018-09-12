package ar.edu.untref.dyasc.productos;

import ar.edu.untref.dyasc.Configuracion;

public class ArticuloDeLibreria extends Producto {
    
    public ArticuloDeLibreria(float precio) {
        super(precio);
    }

    public float obtenerTotal() {
        return super.obtenerTotal() * (1 + Configuracion.IVA);
    }
}
