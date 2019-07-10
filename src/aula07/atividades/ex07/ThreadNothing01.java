package aula07.atividades.ex07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadNothing01 extends Thread {
    Fila fila;
    String name;

    public ThreadNothing01(Fila fila,String name) {
        this.fila = fila;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            fila.semaphore01(name);
            //this.sleep(2000);
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
