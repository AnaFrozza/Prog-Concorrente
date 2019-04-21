/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte2.ex4;

import java.util.List;

/**
 *
 * @author frozza
 */
public class SleepThread extends Thread{

    List<Thread> listThreads;

    public SleepThread(List<Thread> listThreads) {
        this.listThreads = listThreads;
    }

    public void sleep(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        }
    }

    public void run() {
        for (Thread vetor : this.listThreads) {
            sleep(3500);
            System.out.println("Interrompendo Thread " + vetor.getName());
            vetor.interrupt();
            sleep(5500);
        }
    }
}
