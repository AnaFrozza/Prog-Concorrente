package aula08.jantar.solucao03;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Filosofo implements Runnable {
    int id = 0;
    Resource garfo = null;

    public Filosofo(int initId, Resource initr) {
        id = initId;
        garfo = initr;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Filosofo " + id + " pensando");
                Thread.sleep(30);
                System.out.println("Filosofo " + id + " com fome");
                sleep((5-1)*1000);
                garfo.pegar(id);
                System.out.println("Filosofo " + id + " comendo");
                Thread.sleep(40);
                garfo.soltar(id);
            } catch (InterruptedException e) {
                return;
            }
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
