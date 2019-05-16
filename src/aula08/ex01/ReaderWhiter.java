/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula08.ex01;

import java.util.concurrent.Semaphore;

/**
 *
 * @author frozza
 */

/**
 * Implementar soluções para o problema dos leitores-escritores que:
 *      1.1 priorize os leitores
 *      1.2 sem inanição
 *      1.3 priorize os escritores.
 */

public class ReaderWhiter {

    int numReaders = 0;
    Semaphore mutex = new Semaphore(1);
    Semaphore wlock = new Semaphore(1);

    public void startRead() throws InterruptedException {
        mutex.acquire();
        numReaders += 1;
        if(numReaders == 1)
            wlock.acquire();
        mutex.release();
    }

    public void endRead() throws InterruptedException {
        mutex.acquire();
        numReaders -= 1;
        if(numReaders == 0)
            wlock.release();
        mutex.release();
    }

    public void startWhite() throws InterruptedException {
        wlock.acquire(); //bloqueia
    }

    public void endWhite() throws InterruptedException {
        wlock.release(); //libera
    }
    
//    public void le() throws InterruptedException {
//        startRead();
////        faz algo aqui
//        endRead();
//
//    }
//
//    public void escreve() throws InterruptedException {
//        startWhite();
////        faz algo aqui
//        endWhite();
//    }

    public static void main(String[] args) {
        ReaderWhiter t = new ReaderWhiter();
        
        
    }
}
