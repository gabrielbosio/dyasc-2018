package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.productos.ArticuloDeLibreria;
import ar.edu.untref.dyasc.productos.Libro;
import ar.edu.untref.dyasc.productos.Periodicidad;
import ar.edu.untref.dyasc.productos.Periodico;
import ar.edu.untref.dyasc.productos.Producto;
import ar.edu.untref.dyasc.productos.Revista;

public class ProductoTest {
    
    @Test
    public void obtenerTotales() {
        Producto libro = new Libro(100);
        Producto articuloDeLibreria = new ArticuloDeLibreria(100);
        Producto revista = new Revista(100, Periodicidad.DIARIO);
        Producto periodico = new Periodico(100, Periodicidad.DIARIO);
        
        Assert.assertEquals(100.0f, libro.obtenerTotal(), 0.01);
        Assert.assertEquals(121.0f, articuloDeLibreria.obtenerTotal(), 0.01);
        Assert.assertEquals(100.0f, revista.obtenerTotal(), 0.01);
        Assert.assertEquals(100.0f, periodico.obtenerTotal(), 0.01);
    }
}
