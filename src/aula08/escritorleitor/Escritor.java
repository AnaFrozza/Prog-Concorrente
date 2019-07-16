package aula08.escritorleitor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Escritor extends Thread {
    String texto;

    public Escritor(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {
        while(true){

        }

    }

    public void sleep(int val) {

        try {
            Thread.sleep(val);
            System.out.println("Thread Consumidor Acordou!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
