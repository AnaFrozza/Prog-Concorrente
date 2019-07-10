package aula07.atividades.ex05;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadBlocked extends Thread {
    Barreira barreira;
    String name;

    public ThreadBlocked(Barreira barreira, String name) {
        this.barreira = barreira;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            barreira.increment(name);
            sleep(3000);
        }
    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
