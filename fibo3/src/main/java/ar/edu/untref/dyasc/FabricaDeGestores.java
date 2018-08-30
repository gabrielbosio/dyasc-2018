package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.modos.ModoDeLista;
import ar.edu.untref.dyasc.modos.ModoDeSumatoria;

public class FabricaDeGestores {
    
    public GestorDeFuncionamiento construirGestor() {
        GestorDeFuncionamiento nuevoGestor = new GestorDeFuncionamiento();
        nuevoGestor.agregarModo(Configuracion.MODO_LISTA, new ModoDeLista(), true);
        nuevoGestor.agregarModo(Configuracion.MODO_SUMATORIA, new ModoDeSumatoria());
        
        return nuevoGestor;
    }
}
