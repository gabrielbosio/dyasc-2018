package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import interprete.Interprete;
import tablero.CasilleroYaOcupadoException;
import tablero.Direccion;
import tablero.FabricaDeNavios;
import tablero.NavioFueraDeTableroException;
import tablero.Resultado;
import tablero.Tablero;

public class IntegracionTest {

    @Test
    public void disparoEnATresEnUnTableroVacioYObtengoAgua() {
        Tablero tablero = new Tablero(8);

        Resultado resultadoEnA3 = tablero.dispararEn(Interprete.procesar("a3"));

        Assert.assertEquals(Resultado.AGUA, resultadoEnA3);
    }

    @Test
    public void disparoCuatroVecesYErroUnaYHundoTresBotes()
            throws NavioFueraDeTableroException, CasilleroYaOcupadoException {

        Tablero tablero = new Tablero(8);
        tablero.agregar(FabricaDeNavios.crearBote(3, 3));
        tablero.agregar(FabricaDeNavios.crearBote(4, 7));
        tablero.agregar(FabricaDeNavios.crearBote(2, 5));

        Resultado resultadoPrimerDisparo = tablero.dispararEn(Interprete.procesar("c3"));
        Resultado resultadoSegundoDisparo = tablero.dispararEn(Interprete.procesar("d7"));
        Resultado resultadoTercerDisparo = tablero.dispararEn(Interprete.procesar("f4"));
        Resultado resultadoCuartoDisparo = tablero.dispararEn(Interprete.procesar("b5"));

        Assert.assertEquals(Resultado.HUNDIDO, resultadoPrimerDisparo);
        Assert.assertEquals(Resultado.HUNDIDO, resultadoSegundoDisparo);
        Assert.assertEquals(Resultado.AGUA, resultadoTercerDisparo);
        Assert.assertEquals(Resultado.HUNDIDO, resultadoCuartoDisparo);
    }

    @Test
    public void disparoCuatroVecesYErroUnaYHundoUnCrucero()
            throws NavioFueraDeTableroException, CasilleroYaOcupadoException {
        
        Tablero tablero = new Tablero(8);
        tablero.agregar(FabricaDeNavios.crearCrucero(4, 3, Direccion.VERTICAL));

        Resultado resultadoPrimerDisparo = tablero.dispararEn(Interprete.procesar("d3"));
        Resultado resultadoSegundoDisparo = tablero.dispararEn(Interprete.procesar("e3"));
        Resultado resultadoTercerDisparo = tablero.dispararEn(Interprete.procesar("d4"));
        Resultado resultadoCuartoDisparo = tablero.dispararEn(Interprete.procesar("d5"));

        Assert.assertEquals(Resultado.TOCADO, resultadoPrimerDisparo);
        Assert.assertEquals(Resultado.AGUA, resultadoSegundoDisparo);
        Assert.assertEquals(Resultado.TOCADO, resultadoTercerDisparo);
        Assert.assertEquals(Resultado.HUNDIDO, resultadoCuartoDisparo);
    }
}
