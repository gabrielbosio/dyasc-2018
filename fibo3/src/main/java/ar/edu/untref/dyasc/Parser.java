package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    private static final String REGEX = "[-=]";
    private Map<String, String> opcionales;
    private List<String> obligatorios;
    
    public Parser(String[] argumentos) {
        parsearArgumentosObligatorios(argumentos);
        parsearArgumentosOpcionales(argumentos);
    }
    
    public String obtenerArgumentoOpcional(String nombre) {
        return opcionales.get(nombre);
    }
    
    public String obtenerArgumentoObligatorio(int indice) {
        return obligatorios.get(indice);
    }

    public String obtenerArgumentoObligatorio() {
        return obligatorios.get(0);
    }
    
    private void parsearArgumentosObligatorios(String[] argumentos) {
        
        obligatorios = new ArrayList<>();
        
        for (String argumento : argumentos) {
            
            if (argumento.split(REGEX).length == 1) {
                obligatorios.add(argumento);
            }
        }
    }
    
    private void parsearArgumentosOpcionales(String[] argumentos) {
        opcionales = new HashMap<>();
        
        for (String argumento : argumentos) {
            String[] tokens = argumento.split(REGEX);
            
            if (tokens.length == 3) {
                String opcionParseada = tokens[1];
                String valorParseado = tokens[2];
                opcionales.put(opcionParseada, valorParseado);
            }
        }
    }
}
