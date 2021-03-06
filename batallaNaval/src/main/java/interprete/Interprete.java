package interprete;

import ar.edu.untref.dyasc.Coordenada;

public class Interprete {

    private Interprete() {}
    
    public static Coordenada procesar(String entrada) {
        
        if (entrada.length() == 0 || entrada.length() > 2) {
            throw new LongitudInvalidaException();
        }

        char primerCaracter = entrada.charAt(0);
        char segundoCaracter = entrada.charAt(1);
        
        if (primerCaracter < 'a'  || primerCaracter > 'z' ||
            segundoCaracter < '0' || segundoCaracter > '9') {

            throw new CaracterInvalidoException();
        }
        
        int x = primerCaracter - 'a' + 1;
        int y = segundoCaracter - '0';
        
        return new Coordenada(x, y);
    }

}
