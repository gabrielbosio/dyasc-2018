package ar.edu.untref.dyasc;

public class SalidaPorConsola implements Salida {

    @Override
    public void imprimir(String entrada) {
        System.out.println(entrada);
    }
}
