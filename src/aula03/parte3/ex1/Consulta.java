/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte3.ex1;

/**
 *
 * @author frozza
 */

/**
 * Faça um programa em Java que consulte periodicamente o
 * estado de um conjunto de threads.
*/

public class Consulta extends Thread{
    Thread[] list;

    public Consulta(Thread[] list) {
        this.list = list;
    }
    
    public void run(){
        while (true) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: "+list[i].getName());
            }
        }
    }
    
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for(int i = 0; i < 5; i++){
            threads[i] = new ConjuntoThread();
            threads[i].start();
        }
        
        Thread consulta = new Consulta(threads);
        consulta.start();
        
        System.exit(0);
    }
    
}
