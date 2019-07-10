package aula07.atividades.ex04;

/**
 *
 * @author frozza
 */

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Garantir acesso à seção crítica para no máximo N threads
 * Faça um código que possibilite que N threads estejam na seção crítica simultaneamente.
 */


public class Multiplex {
    Semaphore semaphore;
    int numThreads;
    int count;

    public Multiplex(int sizeSemaphoro, int numThreads) {
        this.semaphore = new Semaphore(sizeSemaphoro);
        this.numThreads = numThreads;
        this.count = 0;
    }

    public void increments(String name) {
        try {
            this.semaphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Multiplex.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.count++;
        System.out.println(name + "|Contador: " + this.count);

        this.semaphore.release();
    }

    public void init() {
        for (int i = 0; i < this.numThreads; i++) {
            ThreadsIncrements thread = new ThreadsIncrements(this, "Thread" + i);
            thread.start();
        }
    }

    public static void main(String[] args) {
        Multiplex m  = new Multiplex(3, 9);
        m.init();
    }

}

