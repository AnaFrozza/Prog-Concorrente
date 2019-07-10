package aula07.atividades.ex07;

/**
 *
 * @author frozza
 */

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Semáforos podem ser usadas para representar uma fila
 * Faça um código que implemente duas filas (F1 e F2) com semáforos
 * As threads colocadas na F1 só podem executar se tiver um par na F2
 * Nesse caso, ambas as threads na primeira fila são executadas.
 */


public class Fila {
    Semaphore cankeep01;
    Semaphore cankeep02;
    int numThreads01;
    int numThreads02;
    String concat;
    boolean hasThread02;

    public Fila(int numThreads01, int numThreads02) {
        this.cankeep01 = new Semaphore(0);
        this.cankeep02 = new Semaphore(0);
        this.numThreads01 = numThreads01;
        this.numThreads02 = numThreads02;
        this.hasThread02 = false;
    }

    public void semaphore01(String message) {
        this.cankeep02.release();
        try {
            this.cankeep01.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fila.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(message+"|"+this.concat);
        this.concat = "";

    }

    public void semaphore02(String message) {
        this.cankeep01.release();
        try {
            this.cankeep02.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fila.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.concat = message;
    }


    public void init() {
        for (int i = 0; i < this.numThreads01; i++) {
            ThreadNothing01 thread01 = new ThreadNothing01(this, "Fila01(id:"+i+")");
            thread01.start();
        }

        for (int i = 0; i < this.numThreads02; i++) {
            ThreadNothing02 thread02 = new ThreadNothing02(this, "Fila02(id:"+i+")");
            thread02.start();
        }
    }

    public static void main(String[] args){
        Fila f = new Fila(5, 3);
        f.init();

    }
}
