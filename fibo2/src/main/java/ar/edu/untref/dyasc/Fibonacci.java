package ar.edu.untref.dyasc;

public class Fibonacci {

    public static void main(String[] args) {
        String orientacion = null;
        String direccion = null;
        String sucesion;
        int longitudSucesion = 0;
        boolean opcionesInvalidas = false;
        
        if (args.length == 2) {
            String opcion = args[0].substring(3);
            orientacion = opcion.substring(0, 1);
            direccion = opcion.substring(1, 2);
            longitudSucesion = Integer.valueOf(args[1]);
            
        } else if (args.length == 1) {
            orientacion = "h";
            direccion = "d";
            longitudSucesion = Integer.valueOf(args[0]);
            
        } else {
            opcionesInvalidas = true;
        }
        
        if (!opcionesInvalidas && 
            (orientacion.equals("h") || orientacion.equals("v")) &&
            (direccion.equals("d")   || direccion.equals("i"))) {

            boolean esVertical = orientacion.equals("v");
            boolean invertida = direccion.equals("i");
            int[] valoresSucesion = calcularValoresDeSucesion(longitudSucesion);
            sucesion = generarSucesion(valoresSucesion, esVertical, invertida);
            System.out.println("fibo<" + longitudSucesion + ">:" + sucesion);
        
        } else {
            System.out.println("Opciones no válidas");
        }
    }
    
    private static int[] calcularValoresDeSucesion(int longitud) {
        int sumando1 = 0;
        int sumando2 = 1;
        int[] valoresSucesion = new int[longitud];
        
        for (int i = 0; i < longitud; i++) {
            int temporal = sumando2;
            valoresSucesion[i] = sumando1;
            sumando2 += sumando1;
            sumando1 = temporal;
        }
        
        return valoresSucesion;
    }
    
    private static String generarSucesion(int[] valores, boolean esVertical,
            boolean invertida) {
        
        String sucesion = "";
        String separador;
        
        if (esVertical) {
            separador = "\n";
            
        } else {
            separador = " ";
        }
        
        for (int i = 0; i < valores.length; i++) {
            int indice;
            
            if (invertida) {
                indice = valores.length - i - 1;
                
            } else {
                indice = i;
            }
            
            sucesion += separador + String.valueOf(valores[indice]);
        }
        
        return sucesion;
    }
}
