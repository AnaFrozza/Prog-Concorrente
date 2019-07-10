package aula09.ex02;

/**
 *
 * @author frozza
 */

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * Crie uma classe SharedFifoQueue e use Conditions para
 * controlar se a fila está vazia ou cheia
 * Teste usando threads produtoras e consumidoras.
 */

public class SharedFifoQueue {
    ArrayList<Integer> lista;
    int tamLista;
    Lock lock;
    Condition notFull;
    Condition notEmpty;

    public SharedFifoQueue(int tamLista) {
        this.lista = new ArrayList<>();
        this.tamLista = tamLista;
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public int getValorLista() {
        int valor=-1;
        this.lock.lock();

        try {
            while(this.lista.size() <= 0){
                System.out.println("Thread Consu. Esperando...");
                this.notEmpty.await();
            }

            valor = this.lista.get(0);
            this.lista.remove(0);
            this.tamLista--;
            this.notFull.signal();

        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        } finally {
            this.lock.unlock();
        }
        return valor;
    }

    public void setValorLista(int valor) {
        this.lock.lock();
        try {
            while (this.lista.size() >= this.tamLista) {
                System.out.println("Thread Prod. Esperando...");
                this.notFull.await();
            }

            this.tamLista++;
            this.lista.add(valor);
            this.notEmpty.signal();

        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        } finally {
            this.lock.unlock();
        }
    }

    public void init(){
        Consumidor consu = new Consumidor(this);
        Produtor produ = new Produtor(this);

        consu.start();
        produ.start();
    }

    public static void main(String[] args) {
        SharedFifoQueue s = new SharedFifoQueue(20);
        s.init();
    }
}
