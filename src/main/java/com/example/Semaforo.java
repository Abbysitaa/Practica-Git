package com.example;

public class Semaforo extends Thread {
    String estados[] = { "VERDE", "AMARILLO", "ROJO" };
    String nombre;
    Boolean activo;
    Semaforo otro;

    public Semaforo(String nombre, Boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public void setOtro(Semaforo otro) {
        this.otro = otro;
    }

    public void activar() {
        activo = true;
    }

    public void desactivar() {
        activo = false;
    }

    @Override
    public void run() {
        while (true) {

            if (activo) {

                for (String estado : estados) {
                    System.out.println(nombre + ": " + estado);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                desactivar();
                otro.activar();

            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
