package ar.edu.untref.dyasc;

public class Fibonacci {

    public static void main(String[] args) {
        int longitudSucesion = Integer.valueOf(args[0]);
        int sumando1 = 0;
        int sumando2 = 1;
        String sucesion = "";
        
        for (int i = 0; i < longitudSucesion; i++) {
            int temporal = sumando2;
            sucesion += " " + sumando1;
            sumando2 += sumando1;
            sumando1 = temporal;
        }
        
        System.out.println("fibo<" + longitudSucesion + ">:" + sucesion);
    }
}
