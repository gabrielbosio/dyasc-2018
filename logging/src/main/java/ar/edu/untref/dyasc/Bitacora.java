package ar.edu.untref.dyasc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bitacora {
    private static Bitacora instancia = new Bitacora();
    private List<String> eventos;
    private Salida[] salidas;
    
    private Bitacora() {
        String destino = System.getProperty("bitacora.destino");
        eventos = new ArrayList<>();
        salidas = ParserDeSalidas.parsear(destino);
    }
    
    public static Bitacora obtenerInstancia() {
        return instancia;
    }

    public String registrarEvento(String evento) {
        String eventoDecorado = decorarEvento(evento);
        eventos.add(eventoDecorado);
        
        for (Salida salida : salidas) {            
            salida.imprimir(eventoDecorado);
        }
        
        return eventoDecorado;
    }
    
    private String decorarEvento(String evento) {
        LocalDateTime fechaActual = LocalDateTime.now();
        int dia = fechaActual.getDayOfMonth();
        int mes = fechaActual.getMonthValue();
        int anio = fechaActual.getYear();
        int hora = fechaActual.getHour();
        int minutos = fechaActual.getMinute();
        
        return String.format("%02d/%02d/%04d %02d:%02d %s",
                dia, mes, anio, hora, minutos, evento);
    }
}
