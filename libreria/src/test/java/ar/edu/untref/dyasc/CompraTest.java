package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.cliente.Compra;
import ar.edu.untref.dyasc.productos.ArticuloDeLibreria;
import ar.edu.untref.dyasc.productos.Libro;
import ar.edu.untref.dyasc.productos.Periodicidad;
import ar.edu.untref.dyasc.productos.Periodico;
import ar.edu.untref.dyasc.productos.Revista;

public class CompraTest {

    @Test
    public void obtenerTotales() {
        Compra compraLibro = new Compra(new Libro(100), 4, 2018);
        Compra compraArticulo = new Compra(new ArticuloDeLibreria(100), 4, 2018);
        Compra compraRevista = new Compra(new Revista(100, Periodicidad.DIARIO), 4, 2018);
        Compra compraPeriodico = new Compra(new Periodico(100, Periodicidad.DIARIO), 4, 2018);
        
        Assert.assertEquals(95.0f, compraLibro.obtenerTotal(), 0.01);
        Assert.assertEquals(114.95f, compraArticulo.obtenerTotal(), 0.01);
        Assert.assertEquals(95.0f, compraRevista.obtenerTotal(), 0.01);
        Assert.assertEquals(95.0f, compraPeriodico.obtenerTotal(), 0.01);
    }
    
    @Test
    public void saberSiDebenPagarseComprasDeUnMismoMes() {
        Compra compraLibro = new Compra(new Libro(100), 4, 2018);
        Compra compraArticulo = new Compra(new ArticuloDeLibreria(100), 4, 2018);
        Compra compraRevista = new Compra(new Revista(100, Periodicidad.DIARIO), 4, 2018);
        Compra compraPeriodico = new Compra(new Periodico(100, Periodicidad.DIARIO), 4, 2018);
        
        Assert.assertFalse(compraLibro.debePagarse(3, 2018));
        Assert.assertFalse(compraArticulo.debePagarse(3, 2018));
        Assert.assertFalse(compraRevista.debePagarse(3, 2018));
        Assert.assertFalse(compraPeriodico.debePagarse(3, 2018));
        
        Assert.assertTrue(compraLibro.debePagarse(4, 2018));
        Assert.assertTrue(compraArticulo.debePagarse(4, 2018));
        Assert.assertTrue(compraRevista.debePagarse(4, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(4, 2018));
        
        Assert.assertFalse(compraLibro.debePagarse(5, 2018));
        Assert.assertFalse(compraArticulo.debePagarse(5, 2018));
        Assert.assertFalse(compraRevista.debePagarse(5, 2018));
        Assert.assertFalse(compraPeriodico.debePagarse(5, 2018));
    }
    
    @Test
    public void saberSiDebenPagarseComprasDeDistintosMeses() {
        Compra compraLibro = new Compra(new Libro(100), 4, 2018);
        Compra compraArticulo1 = new Compra(new ArticuloDeLibreria(100), 4, 2018);
        Compra compraRevista = new Compra(new Revista(100, Periodicidad.DIARIO), 4, 2018);
        Compra compraArticulo2 = new Compra(new ArticuloDeLibreria(70), 5, 2018);
        Compra compraPeriodico = new Compra(new Periodico(50, Periodicidad.DIARIO), 5, 2018);
        
        Assert.assertFalse(compraLibro.debePagarse(3, 2018));
        Assert.assertFalse(compraArticulo1.debePagarse(3, 2018));
        Assert.assertFalse(compraRevista.debePagarse(3, 2018));
        Assert.assertFalse(compraArticulo2.debePagarse(3, 2018));
        Assert.assertFalse(compraPeriodico.debePagarse(3, 2018));

        Assert.assertTrue(compraLibro.debePagarse(4, 2018));
        Assert.assertTrue(compraArticulo1.debePagarse(4, 2018));
        Assert.assertTrue(compraRevista.debePagarse(4, 2018));
        Assert.assertFalse(compraArticulo2.debePagarse(4, 2018));
        Assert.assertFalse(compraPeriodico.debePagarse(4, 2018));

        Assert.assertFalse(compraLibro.debePagarse(5, 2018));
        Assert.assertFalse(compraArticulo1.debePagarse(5, 2018));
        Assert.assertFalse(compraRevista.debePagarse(5, 2018));
        Assert.assertTrue(compraArticulo2.debePagarse(5, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(5, 2018));
    }
}
