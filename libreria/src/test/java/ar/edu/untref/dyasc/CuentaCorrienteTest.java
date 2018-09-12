package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.cliente.CuentaCorriente;
import ar.edu.untref.dyasc.productos.ArticuloDeLibreria;
import ar.edu.untref.dyasc.productos.Libro;
import ar.edu.untref.dyasc.productos.Periodicidad;
import ar.edu.untref.dyasc.productos.Periodico;
import ar.edu.untref.dyasc.productos.Revista;

public class CuentaCorrienteTest {
    private static final double DELTA = 0.01;
    private CuentaCorriente cuentaCorriente;
    
    @Before
    public void inicializar() {
        cuentaCorriente = new CuentaCorriente();
    }
    
    @Test
    public void obtenerTotalDeComprasEnUnMismoMes() {
        cuentaCorriente.agregarCompra(new Libro(100), 3, 2018);
        cuentaCorriente.agregarCompra(new ArticuloDeLibreria(100), 3, 2018);
        cuentaCorriente.agregarCompra(new Revista(100, Periodicidad.DIARIO), 3, 2018);
        cuentaCorriente.agregarCompra(new Periodico(100, Periodicidad.DIARIO), 3, 2018);
        
        Assert.assertEquals(399.95, cuentaCorriente.obtenerTotal(3, 2018), DELTA);
    }
    
    @Test
    public void obtenerTotalDeComprasEnDistintosMeses() {
        cuentaCorriente.agregarCompra(new Libro(100), 3, 2018);
        cuentaCorriente.agregarCompra(new ArticuloDeLibreria(100), 3, 2018);
        cuentaCorriente.agregarCompra(new Revista(100, Periodicidad.DIARIO), 3, 2018);
        cuentaCorriente.agregarCompra(new Libro(150), 4, 2018);
        cuentaCorriente.agregarCompra(new Periodico(40, Periodicidad.SEMANAL), 4, 2018);
        
        Assert.assertEquals(304.95, cuentaCorriente.obtenerTotal(3, 2018), DELTA);
        Assert.assertEquals(180.5, cuentaCorriente.obtenerTotal(4, 2018), DELTA);
    }
    
    @Test
    public void obtenerTotalDeComprasDeUnAnioEnteroEnUnMismoAnio() {
        cuentaCorriente.agregarCompra(new Libro(100), 3, 2018);
        cuentaCorriente.agregarCompra(new ArticuloDeLibreria(100), 3, 2018);
        cuentaCorriente.agregarCompra(new Revista(100, Periodicidad.DIARIO), 3, 2018);
        cuentaCorriente.agregarCompra(new Libro(150), 4, 2018);
        cuentaCorriente.agregarCompra(new Periodico(40, Periodicidad.SEMANAL), 4, 2018);
        
        Assert.assertEquals(485.45f, cuentaCorriente.obtenerTotal(2018), DELTA);
    }

    @Test
    public void obtenerTotalDeComprasYSuscripcionesDeUnAnioEnteroEnUnMismoAnio() {
        cuentaCorriente.agregarCompra(new Libro(100), 3, 2018);
        cuentaCorriente.agregarCompra(new ArticuloDeLibreria(100), 3, 2018);
        cuentaCorriente.agregarCompra(new Revista(100, Periodicidad.DIARIO), 3, 2018);
        cuentaCorriente.agregarCompra(new Libro(150), 4, 2018);
        cuentaCorriente.agregarSuscripcion(new Periodico(40, Periodicidad.SEMANAL), 4, 2018, 3);
        
        Assert.assertEquals(903.45f, cuentaCorriente.obtenerTotal(2018), DELTA);
    }
    
    @Test
    public void obtenerTotalDeComprasYSuscripcionesDeUnAnioEnteroEnDistintosAnios() {
        cuentaCorriente.agregarCompra(new Libro(100), 3, 2018);
        cuentaCorriente.agregarCompra(new ArticuloDeLibreria(100), 3, 2018);
        cuentaCorriente.agregarCompra(new Revista(100, Periodicidad.DIARIO), 3, 2018);
        cuentaCorriente.agregarCompra(new Libro(150), 4, 2019);
        cuentaCorriente.agregarCompra(new ArticuloDeLibreria(80), 2, 2019);
        cuentaCorriente.agregarSuscripcion(new Periodico(40, Periodicidad.SEMANAL), 4, 2018, 3);
        
        Assert.assertEquals(760.95f, cuentaCorriente.obtenerTotal(2018), DELTA);
        Assert.assertEquals(234.46f, cuentaCorriente.obtenerTotal(2019), DELTA);
    }
    
    @Test
    public void obtenerTotalDeComprasYDeUnaSuscripcionAnual() {
        Periodico periodico = new Periodico(40, Periodicidad.SEMANAL);
        cuentaCorriente.agregarCompra(new Libro(100), 3, 2018);
        cuentaCorriente.agregarCompra(new ArticuloDeLibreria(100), 3, 2018);
        cuentaCorriente.agregarCompra(new Revista(100, Periodicidad.DIARIO), 3, 2018);
        cuentaCorriente.agregarCompra(new Libro(150), 4, 2018);
        cuentaCorriente.agregarSuscripcion(periodico, 5, 2018, 12);
        
        Assert.assertEquals(1471.45f, cuentaCorriente.obtenerTotal(2018), DELTA);
        Assert.assertEquals(512.0f, cuentaCorriente.obtenerTotal(2019), DELTA);
    }
}
