package com.example;

public class CruceVial {
    public static void main(String[] args) throws InterruptedException {
        Semaforo s1 = new Semaforo("S1", true);
        Semaforo s2 = new Semaforo("S2", false);

        s1.setOtro(s2);
        s2.setOtro(s1);

        s1.start();
        s2.start();

    }
}
