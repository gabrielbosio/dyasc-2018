package ar.edu.untref.dyasc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BatallaNaval {

    private static final int TAMANIO_TABLERO = 8;
    private static int naviosRestantes;

    public static void main(String[] args) {
        Tablero tablero = new Tablero(TAMANIO_TABLERO);
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        inicializar(tablero);
        
        while (loop(tablero, lector));
    }
    
    private static void inicializar(Tablero tablero) {
        
        for (int y = 1; y <= TAMANIO_TABLERO; y++) {
            
            for (int x = 1; x <= TAMANIO_TABLERO; x++) {
                boolean seDebeCrearNavio = Math.random() > 0.9;
                
                if (seDebeCrearNavio) {
                    Navio nuevoNavio;
                    boolean seCreaUnCrucero = Math.random() > 0.7;

                    if (seCreaUnCrucero) {
                        Direccion direccion = Direccion.HORIZONTAL;
                        
                        if (Math.random() > 0.5) {
                            direccion = Direccion.VERTICAL;
                        }
                        
                        nuevoNavio = FabricaDeNavios.crearCrucero(x, y, direccion);
                    
                    } else {
                        nuevoNavio = FabricaDeNavios.crearBote(x, y);
                    }
                    
                    
                    try {
                        tablero.agregar(nuevoNavio);
                        naviosRestantes++;
                        
                    } catch (NavioFueraDeTableroException | CasilleroYaOcupadoException e) {}
                }
            }
        }
    }

    private static boolean loop(Tablero tablero, BufferedReader lector) {
        boolean debeSeguirElLoop = true;
        System.out.println("Ingrese las coordenadas de disparo: ");
        
        try {
            String coordenadas = lector.readLine();
            Resultado resultado = tablero.dispararEn(Interprete.procesar(coordenadas));
            
            if (resultado == Resultado.HUNDIDO) {
                naviosRestantes--;
            }
            
            System.out.println("Resultado: " + resultado.toString());

            if (naviosRestantes == 0) {
                System.out.println("Hundiste todos los barcos!");
                debeSeguirElLoop = false;
            }
            
        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida.");
            
        } catch (AtaqueFueraDelTableroException e) {
            System.out.println("No se puede disparar fuera del tablero.");
        }
        
        return debeSeguirElLoop;
    }
}
