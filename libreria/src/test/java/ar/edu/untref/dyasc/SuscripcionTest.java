package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.cliente.Compra;
import ar.edu.untref.dyasc.cliente.Suscripcion;
import ar.edu.untref.dyasc.productos.Periodicidad;
import ar.edu.untref.dyasc.productos.Periodico;
import ar.edu.untref.dyasc.productos.Revista;

public class SuscripcionTest {

    @Test
    public void obtenerTotales() {
        Revista revista = new Revista(100, Periodicidad.QUINCENAL);
        Periodico periodico = new Periodico(100, Periodicidad.SEMANAL);
        Compra compraRevista = new Suscripcion(revista, 4, 2018, 3);
        Compra compraPeriodico = new Suscripcion(periodico, 4, 2018, 3);
        
        Assert.assertEquals(190.0f, compraRevista.obtenerTotal(), 0.01);
        Assert.assertEquals(380.0f, compraPeriodico.obtenerTotal(), 0.01);
    }
    
    @Test
    public void obtenerTotalesTeniendoUnaSuscripcionAnual() {
        Revista revista = new Revista(100, Periodicidad.QUINCENAL);
        Periodico periodico = new Periodico(100, Periodicidad.SEMANAL);
        Compra compraRevista = new Suscripcion(revista, 4, 2018, 3);
        Compra compraPeriodico = new Suscripcion(periodico, 4, 2018, 12);
        
        Assert.assertEquals(190.0f, compraRevista.obtenerTotal(), 0.01);
        Assert.assertEquals(320.0f, compraPeriodico.obtenerTotal(), 0.01);
    }
    
    @Test
    public void saberSiDebenPagarseSuscripcionesDeUnMismoMes() {
        Revista revista = new Revista(100, Periodicidad.DIARIO);
        Periodico periodico = new Periodico(100, Periodicidad.DIARIO);
        Compra compraRevista = new Suscripcion(revista, 4, 2018, 3);
        Compra compraPeriodico = new Suscripcion(periodico, 4, 2018, 3);

        Assert.assertFalse(compraRevista.debePagarse(12, 2017));
        Assert.assertFalse(compraPeriodico.debePagarse(12, 2017));
        
        Assert.assertFalse(compraRevista.debePagarse(3, 2018));
        Assert.assertFalse(compraPeriodico.debePagarse(3, 2018));
        
        Assert.assertTrue(compraRevista.debePagarse(4, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(4, 2018));
        
        Assert.assertTrue(compraRevista.debePagarse(5, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(5, 2018));
        
        Assert.assertFalse(compraRevista.debePagarse(7, 2018));
        Assert.assertFalse(compraPeriodico.debePagarse(7, 2018));
    }
    
    @Test
    public void saberSiDebenPagarseSuscripcionesDeDistintosMeses() {
        Revista revista = new Revista(100, Periodicidad.DIARIO);
        Periodico periodico = new Periodico(50, Periodicidad.DIARIO);
        Compra compraRevista = new Suscripcion(revista, 4, 2018, 3);
        Compra compraPeriodico = new Suscripcion(periodico, 5, 2018, 3);
        
        Assert.assertFalse(compraRevista.debePagarse(12, 2017));
        Assert.assertFalse(compraPeriodico.debePagarse(12, 2017));
        
        Assert.assertFalse(compraRevista.debePagarse(3, 2018));
        Assert.assertFalse(compraPeriodico.debePagarse(3, 2018));

        Assert.assertTrue(compraRevista.debePagarse(4, 2018));
        Assert.assertFalse(compraPeriodico.debePagarse(4, 2018));

        Assert.assertTrue(compraRevista.debePagarse(5, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(5, 2018));
        
        Assert.assertTrue(compraRevista.debePagarse(6, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(6, 2018));
        
        Assert.assertFalse(compraRevista.debePagarse(7, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(7, 2018));
        
        Assert.assertFalse(compraRevista.debePagarse(7, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(7, 2018));
    }
    
    @Test
    public void saberSiDebenPagarseSuscripcionesHastaElProximoAnio() {
        Revista revista = new Revista(100, Periodicidad.DIARIO);
        Periodico periodico = new Periodico(100, Periodicidad.DIARIO);
        Compra compraRevista = new Suscripcion(revista, 4, 2018, 9);
        Compra compraPeriodico = new Suscripcion(periodico, 4, 2018, 12);
        
        Assert.assertFalse(compraRevista.debePagarse(3, 2018));
        Assert.assertFalse(compraPeriodico.debePagarse(3, 2018));
        
        Assert.assertTrue(compraRevista.debePagarse(4, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(4, 2018));
        
        Assert.assertTrue(compraRevista.debePagarse(5, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(5, 2018));
        
        Assert.assertTrue(compraRevista.debePagarse(7, 2018));
        Assert.assertTrue(compraPeriodico.debePagarse(7, 2018));
        
        Assert.assertFalse(compraRevista.debePagarse(1, 2019));
        Assert.assertTrue(compraPeriodico.debePagarse(1, 2019));
        
        Assert.assertFalse(compraRevista.debePagarse(4, 2019));
        Assert.assertFalse(compraPeriodico.debePagarse(4, 2019));

        Assert.assertFalse(compraRevista.debePagarse(5, 2019));
        Assert.assertFalse(compraPeriodico.debePagarse(5, 2019));
    }
}
