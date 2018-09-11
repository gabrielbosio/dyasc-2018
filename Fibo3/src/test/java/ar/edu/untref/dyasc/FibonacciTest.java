package ar.edu.untref.dyasc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.opciones.OpcionNoValidaException;

public class FibonacciTest {
    ProcesoFibonacci proceso;
    
    @Before
    public void inicializar() {
        proceso = new ProcesoFibonacci();
    }
    
    @Test
    public void calcularFibonacciSoloConArgumentoObligatorioCinco()
            throws OpcionNoValidaException, IOException {
        
        String[] argumentos = new String[] {"5"};
        Parser parser = new Parser(argumentos);
        int longitud = Integer.parseInt(parser.obtenerArgumentoObligatorio());
        String opcion = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_OPCION);
        String idModo = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_MODO);
        String ruta = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_SALIDA);
        String resultado = proceso.ejecutar(opcion, idModo, longitud, ruta);
        String salida = resultado.toString();
        
        Assert.assertEquals("fibo<5>: 0 1 1 2 3", salida);
    }
    
    @Test
    public void calcularFibonacciSoloConArgumentoObligatorioOcho()
            throws OpcionNoValidaException, IOException {
        
        String[] argumentos = new String[] {"8"};
        Parser parser = new Parser(argumentos);
        int longitud = Integer.parseInt(parser.obtenerArgumentoObligatorio());
        String opcion = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_OPCION);
        String idModo = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_MODO);
        String ruta = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_SALIDA);
        String resultado = proceso.ejecutar(opcion, idModo, longitud, ruta);
        String salida = resultado.toString();
        
        Assert.assertEquals("fibo<8>: 0 1 1 2 3 5 8 13", salida);
    }
    
    @Test
    public void calcularFibonacciDeFormaVerticalYDirecta()
            throws OpcionNoValidaException, IOException {
        
        String[] argumentos = new String[] {"-o=vd", "5"};
        Parser parser = new Parser(argumentos);
        int longitud = Integer.parseInt(parser.obtenerArgumentoObligatorio());
        String opcion = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_OPCION);
        String idModo = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_MODO);
        String ruta = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_SALIDA);
        String resultado = proceso.ejecutar(opcion, idModo, longitud, ruta);
        String salida = resultado.toString();
        
        Assert.assertEquals("fibo<5>:\n0\n1\n1\n2\n3", salida);
    }

    @Test
    public void calcularFibonacciDeFormaHorizontalEInversa()
            throws OpcionNoValidaException, IOException {
        
        String[] argumentos = new String[] {"-o=hi", "8"};
        Parser parser = new Parser(argumentos);
        int longitud = Integer.parseInt(parser.obtenerArgumentoObligatorio());
        String opcion = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_OPCION);
        String idModo = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_MODO);
        String ruta = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_SALIDA);
        String resultado = proceso.ejecutar(opcion, idModo, longitud, ruta);
        String salida = resultado.toString();
        
        Assert.assertEquals("fibo<8>: 13 8 5 3 2 1 1 0", salida);
    }

    @Test
    public void calcularFibonacciDeFormaVerticalEInversa()
            throws OpcionNoValidaException, IOException {
        
        String[] argumentos = new String[] {"-o=vi", "8"};
        Parser parser = new Parser(argumentos);
        int longitud = Integer.parseInt(parser.obtenerArgumentoObligatorio());
        String opcion = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_OPCION);
        String idModo = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_MODO);
        String ruta = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_SALIDA);
        String resultado = proceso.ejecutar(opcion, idModo, longitud, ruta);
        String salida = resultado.toString();
        
        Assert.assertEquals("fibo<8>:\n13\n8\n5\n3\n2\n1\n1\n0", salida);
    }
    
    @Test(expected = OpcionNoValidaException.class)
    public void calcularFibonacciConOpcionNoValida()
            throws OpcionNoValidaException, IOException {
        
        String[] argumentos = new String[] {"-o=xy", "8"};
        Parser parser = new Parser(argumentos);
        int longitud = Integer.parseInt(parser.obtenerArgumentoObligatorio());
        String opcion = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_OPCION);
        String idModo = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_MODO);
        String ruta = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_SALIDA);
        proceso.ejecutar(opcion, idModo, longitud, ruta);
    }

    @Test
    public void calcularFibonacciConSalidaAArchivo()
            throws OpcionNoValidaException, IOException {
        
        String[] argumentos = new String[] {"-o=vd", "-f=salida.txt", "5"};
        Parser parser = new Parser(argumentos);
        int longitud = Integer.parseInt(parser.obtenerArgumentoObligatorio());
        String opcion = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_OPCION);
        String idModo = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_MODO);
        String ruta = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_SALIDA);
        String resultado = proceso.ejecutar(opcion, idModo, longitud, ruta);
        String salida = resultado.toString();
        String leido = leerArchivo(ruta);
        borrarArchivo(ruta);
        
        Assert.assertEquals("fibo<5> guardado en salida.txt", salida);
        Assert.assertEquals("fibo<5>:\n0\n1\n1\n2\n3", leido);
    }

    @Test
    public void calcularFibonacciConOpcionSumatoria()
            throws OpcionNoValidaException, IOException {
        
        String[] argumentos = new String[] {"-o=hd", "-m=s", "5"};
        Parser parser = new Parser(argumentos);
        int longitud = Integer.parseInt(parser.obtenerArgumentoObligatorio());
        String opcion = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_OPCION);
        String idModo = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_MODO);
        String ruta = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_SALIDA);
        String resultado = proceso.ejecutar(opcion, idModo, longitud, ruta);
        String salida = resultado.toString();
        
        Assert.assertEquals("fibo<5>s: 7", salida);
    }

    @Test
    public void calcularFibonacciConSalidaAArchivoConOpcionSumatoria()
            throws OpcionNoValidaException, IOException {
        
        String[] argumentos = new String[] {"-o=vd", "-f=salida.txt", "-m=s", "5"};
        Parser parser = new Parser(argumentos);
        int longitud = Integer.parseInt(parser.obtenerArgumentoObligatorio());
        String opcion = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_OPCION);
        String idModo = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_MODO);
        String ruta = parser.obtenerArgumentoOpcional(Configuracion.ARGUMENTO_SALIDA);
        String resultado = proceso.ejecutar(opcion, idModo, longitud, ruta);
        String salida = resultado.toString();
        String leido = leerArchivo(ruta);
        borrarArchivo(ruta);
        
        Assert.assertEquals("fibo<5> guardado en salida.txt", salida);
        Assert.assertEquals("fibo<5>s:\n7", leido);
    }
    
    private String leerArchivo(String ruta) throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(ruta));
        String leido;
        String linea;
        ArrayList<String> lineas = new ArrayList<>();
        
        while ((linea = lector.readLine()) != null) {
            lineas.add(linea);
        }
        
        leido = String.join("\n", lineas);
        lector.close();
        
        return leido;
    }
    
    private void borrarArchivo(String ruta) {
        new File(ruta).delete();
    }
}
