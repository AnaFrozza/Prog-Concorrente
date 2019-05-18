/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula06a.ex3;

/**
 *
 * @author frozza
 */
public class ThreadIncrement extends Thread {

    BoundedCounter bouded;
    int tempo;

    public ThreadIncrement(BoundedCounter bouded, int tempo) {
        this.bouded = bouded;
        this.tempo = tempo;
    }

    @Override
    public void run() {
        while (true) {
            this.bouded.increment();
            sleep(this.tempo);
        }
    }

    public void sleep(int var) {
        try {
            Thread.sleep(var);
        } catch (InterruptedException ex) {
            System.out.println("Erro: " + ex);
        }
    }
}
