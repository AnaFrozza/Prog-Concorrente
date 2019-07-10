package aula07.atividades.ex04;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadsIncrements extends Thread {
    Multiplex multiplex;
    String name;

    public ThreadsIncrements(Multiplex multiplex, String name) {
        this.multiplex = multiplex;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            this.multiplex.increments(this.name);
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
