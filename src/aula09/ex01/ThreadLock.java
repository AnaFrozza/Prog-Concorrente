package aula09.ex01;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author frozza
 */

/**
 * Faça um programa usando Lock para simular a atualização de
 * um contador que é acessado por múltiplas threads
 * O contador pode diminuir e aumentar.
 */


public class ThreadLock {
    int contador;
    ReentrantLock lock;

    public ThreadLock() {
        this.contador = 0;
        this.lock = new ReentrantLock();
    }

    public void incrementeDecremente(boolean increase) {
        this.lock.lock();
        try {
            if (increase) {
                this.contador++;
            } else {
                this.contador--;
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void verValor() {
        System.out.println("Valor: " + this.contador);
    }

    public void init() {
        IncrementeDecremente thr01 = new IncrementeDecremente(this, true);
        IncrementeDecremente thr02 = new IncrementeDecremente(this, false);

        thr01.start();
        thr02.start();
    }

    public static void main(String[] args) {
        ThreadLock t = new ThreadLock();
        t.init();
    }
}
