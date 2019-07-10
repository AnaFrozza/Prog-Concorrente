package aula08.jantar.solucao02;

import java.util.concurrent.Semaphore;

public class Jantar extends Resource {
    int n = 0;
    Semaphore[] garfo = null;
    Semaphore lock;

    public Jantar(int initN) {
        n = initN;
        this.lock = new Semaphore(1);
        garfo = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            garfo[i] = new Semaphore(1);
        }
    }

    @Override
    public void pegar(int i) {
        try {
            this.lock.acquire();
            garfo[i].acquire();
            garfo[(i + 1) % n].acquire();
            this.lock.release();
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void soltar(int i) {
        garfo[i].release();
        garfo[(i + 1) % n].release();
    }

    public static void main(String[] args) {
        Jantar jantar = new Jantar(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Filosofo(i, jantar)).start();
        }
    }
}
