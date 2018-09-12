package ar.edu.untref.dyasc.productos;

public enum Periodicidad {
    DIARIO (30),
    SEMANAL (4),
    QUINCENAL (2),
    MENSUAL (1);
    
    private int frecuencia;
    
    Periodicidad(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    
    public int enVecesAlMes() {
        return frecuencia;
    }
}
