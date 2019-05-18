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
public class ThreadDecrement extends Thread{
    BoundedCounter bouded;
    int tempo;

    public ThreadDecrement(BoundedCounter bouded, int tempo) {
        this.bouded = bouded;
        this.tempo = tempo;
    }

    @Override
    public void run() {
        while (true) {
            this.bouded.decrement();
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
