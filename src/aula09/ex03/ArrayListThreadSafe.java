package aula09.ex03;

/**
 *
 * @author frozza
 */

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Faça uma classe ArrayListThreadSafe usando ReadWriteLock
 * Teste usando threads que realizam leitura e escrita para essa
 * estrutura.
 */

public class ArrayListThreadSafe {
    String texto;
    ReentrantReadWriteLock readWriteLock;

    public ArrayListThreadSafe() {
        this.texto = "";
        this.readWriteLock = new ReentrantReadWriteLock();

    }

    public void escrever(String texto){
        this.readWriteLock.writeLock().lock();
        try {
            this.texto += texto;
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }


    public String ler(){
        this.readWriteLock.readLock().lock();
        try {
            return this.texto;
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void init(int numLeitores, int numEscritores){
        for(int i=0;i<numLeitores;i++){
            Leitores leitores = new Leitores(this);
            leitores.start();
        }

        for(int i=0;i<numEscritores;i++){
            Escritor escritores = new Escritor(this);
            escritores.start();
        }

    }

    public static void main(String[] args) {
        ArrayListThreadSafe threadSafe = new ArrayListThreadSafe();
        threadSafe.init(3, 5);
    }
}
