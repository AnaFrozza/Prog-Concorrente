/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte2.ex4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frozza
 */

/**
 * Faça uma Thread que monitora um conjunto de threads e
 * exiba quais threads receberam sinais de interrupção.
 */


public class Monitora extends Thread{

    List<Thread> threads;
    
    public Monitora(List<Thread> threads){
        this.threads = threads;
    }
    
    public void sleep(int tempo) {
        try {
            System.out.println("Sleep");
            Thread.sleep(tempo);
            System.out.println("Up");

        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        }
    }
    
    @Override
    public void run(){
        
        for (Thread thread : threads) {
            thread.start();
        }
        
        Thread t = new Monitora(threads);
        t.start();
        sleep(1000);
        
        List<Thread> list = this.threads;
        while(true){
            for (Thread thread : list) {
                if(thread.isInterrupted()){
                    System.out.println("Thread: "+thread.getName()+" gerou interopição");
                    sleep(1000);
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        List<Thread> listThreads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            listThreads.add(new Thread(new SleepThread(listThreads)));
        }
        
        Thread monitora = new Thread(new Monitora(listThreads));
        monitora.start();
        
        System.exit(0);
    }
    
}
