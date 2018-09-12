package ar.edu.untref.dyasc;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.cliente.Cliente;
import ar.edu.untref.dyasc.cliente.Direccion;
import ar.edu.untref.dyasc.productos.ArticuloDeLibreria;
import ar.edu.untref.dyasc.productos.Libro;
import ar.edu.untref.dyasc.productos.Periodicidad;
import ar.edu.untref.dyasc.productos.Periodico;
import ar.edu.untref.dyasc.productos.Revista;

public class LibreriaTest {
    private static final float DELTA = 0.01f;
    private static final int CANTIDAD_DE_CLIENTES = 3;
    private Libreria libreria;
    private Cliente alicia;
    private Cliente barbara;
    private Cliente carlos;
    
    @Before
    public void inicializar() {
        libreria = new Libreria();
        
        alicia = new Cliente(new Direccion("Amenabar", 2500, "CABA"));
        barbara = new Cliente(new Direccion("Belgrano", 1894, "Tres de Febrero"));
        carlos = new Cliente(new Direccion("Capdevilla", 6974, "San Martin"));
        
        libreria.vender(    alicia,  new Libro(100),                          2, 2018     );
        libreria.vender(    alicia,  new ArticuloDeLibreria(80),              2, 2018     );
        libreria.suscribirA(alicia,  new Revista(80, Periodicidad.QUINCENAL), 3, 2018, 6  );
        
        libreria.vender(    barbara, new ArticuloDeLibreria(150),             2, 2018     );
        libreria.vender(    barbara, new Libro(300),                          3, 2018     );
        libreria.vender(    barbara, new Revista(100, Periodicidad.SEMANAL),  3, 2018     );
        libreria.vender(    barbara, new Libro(450),                          4, 2018     );
        
        libreria.vender(    carlos,  new Libro(300),                          2, 2018     );
        libreria.vender(    carlos,  new Periodico(50, Periodicidad.DIARIO),  4, 2018     );
        libreria.suscribirA(carlos,  new Periodico(50, Periodicidad.SEMANAL), 4, 2018, 12 );
    }
    
    @Test
    public void chequearCobrosMensuales() {
        Map<Cliente, Float> cobrosFebrero = libreria.calcularCobrosMensuales(2, 2018);
        Map<Cliente, Float> cobrosMarzo = libreria.calcularCobrosMensuales(3, 2018);
        Map<Cliente, Float> cobrosAbril = libreria.calcularCobrosMensuales(4, 2018);
        Map<Cliente, Float> cobrosMayo = libreria.calcularCobrosMensuales(5, 2018);
        Map<Cliente, Float> cobrosSeptiembre = libreria.calcularCobrosMensuales(10, 2018);
        Map<Cliente, Float> cobrosAbrilSiguiente = libreria.calcularCobrosMensuales(4, 2019);

        float[] actualesFebrero = crearArregloDeCobros(cobrosFebrero);
        float[] actualesMarzo = crearArregloDeCobros(cobrosMarzo);
        float[] actualesAbril = crearArregloDeCobros(cobrosAbril);
        float[] actualesMayo = crearArregloDeCobros(cobrosMayo);
        float[] actualesSeptiembre = crearArregloDeCobros(cobrosSeptiembre);
        float[] actualesAbrilSiguiente = crearArregloDeCobros(cobrosAbrilSiguiente);
        
        float[] esperadosFebrero = new float[]          {186.96f,   172.425f,   285.0f  };
        float[] esperadosMarzo = new float[]            {152.0f,    380.0f,     0.0f    };
        float[] esperadosAbril = new float[]            {152.0f,    427.5f,     207.5f  };
        float[] esperadosMayo = new float[]             {152.0f,    0.0f,       160.0f  };
        float[] esperadosSeptiembre = new float[]       {0.0f,      0.0f,       160.0f  };
        float[] esperadosAbrilSiguiente = new float[]   {0.0f,      0.0f,       0.0f    };
        
        Assert.assertArrayEquals(esperadosFebrero, actualesFebrero, DELTA);
        Assert.assertArrayEquals(esperadosMarzo, actualesMarzo, DELTA);
        Assert.assertArrayEquals(esperadosAbril, actualesAbril, DELTA);
        Assert.assertArrayEquals(esperadosMayo, actualesMayo, DELTA);
        Assert.assertArrayEquals(esperadosSeptiembre, actualesSeptiembre, DELTA);
        Assert.assertArrayEquals(esperadosAbrilSiguiente, actualesAbrilSiguiente, DELTA);
    }
    
    @Test
    public void chequearCobrosAnuales() {
        Map<Cliente, Float> cobrosEsteAnio = libreria.calcularCobrosAnuales(2018);
        Map<Cliente, Float> cobrosAnioQueViene = libreria.calcularCobrosAnuales(2019);
        
        float[] actualesEsteAnio = crearArregloDeCobros(cobrosEsteAnio);
        float[] actualesAnioQueViene = crearArregloDeCobros(cobrosAnioQueViene);
        
        float[] esperadosEsteAnio = new float[]     {1098.96f,  979.925f,   1772.5f };
        float[] esperadosAnioQueViene = new float[] {0.0f,      0.0f,       480.0f  };
        
        Assert.assertArrayEquals(esperadosEsteAnio, actualesEsteAnio, DELTA);
        Assert.assertArrayEquals(esperadosAnioQueViene, actualesAnioQueViene, DELTA);
    }
    
    private float[] crearArregloDeCobros(Map<Cliente, Float> cobros) {
        float[] arregloDeCobros = new float[CANTIDAD_DE_CLIENTES];
        arregloDeCobros[0] = cobros.get(alicia);
        arregloDeCobros[1] = cobros.get(barbara);
        arregloDeCobros[2] = cobros.get(carlos);
        
        return arregloDeCobros;
    }
}
