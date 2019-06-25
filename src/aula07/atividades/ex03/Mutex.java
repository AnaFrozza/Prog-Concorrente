/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula07.atividades.ex03;

import java.util.concurrent.Semaphore;

/**
 *
 * @author frozza
 */


/**
 * Garantir acesso exclusivo à seção crítica
 * Faça um código que possibilite que 2 ou mais threads realizem o incremento de um contador
 * Faça a exclusão mútua com semáforo.
 */


public class Mutex {
    Semaphore semaforo;
    Threads t1;
    Threads t2;
    Threads t3;
    int count;
    
    public Mutex(){
        this.count = 0;
        this.semaforo = new Semaphore(1);
        this.t1 = new Threads(this, "thread1");
        this.t2 = new Threads(this, "thread2");
        this.t3 = new Threads(this, "thread3");
    }
    
    public void increment(String thread){
        try {
            this.semaforo.acquire();
        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        }
        
        this.count++;
        System.out.println(thread+" contando: "+this.count);
        this.semaforo.release();
    }
    
    public void init(){
        this.t1.start();
        this.t2.start();
        this.t3.start();
    }
    
    public static void main(String[] args) {
        Mutex mutex = new Mutex();
        mutex.init();
    }
    
    
    
}
