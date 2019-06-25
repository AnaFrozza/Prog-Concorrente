/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula07.atividades.ex01;

import java.util.concurrent.Semaphore;

/**
 *
 * @author frozza
 */
/**
 * Enviar sinal para outra thread para indicar que um evento ocorreu Faça um
 * código que uma thread t1 e t2 são inicializadas simultaneamente, mas a t2
 * pode somente continuar a execução após a sinalização de t1.
 */
public class Sinalizacao {

    Semaphore semaforo;
    Threads t1;
    Threads t2;

    public Sinalizacao() {
        this.semaforo = new Semaphore(1);
        this.t1 = new Threads(this, "Thread1");
        this.t2 = new Threads(this, "Thread2");
    }

    public void sinal(String sinal) {
        try {
            System.out.println("Sinal!");
            this.semaforo.acquire();
        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        }
    }

    public void init() {
        this.t1.start();
        this.t2.start();
    }

    public static void main(String[] args) {
        Sinalizacao sinal = new Sinalizacao();
        sinal.init();
    }
}
