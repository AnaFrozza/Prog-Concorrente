/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte2.ex1;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author frozza
 */

/**
 * Faça um programa em Java que inicie três threads e,
 * cada thread, espere um tempo aleatório para terminar.
*/

public class Threads extends Thread{
        
    private void t() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep((int) Math.random());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Thread id: "+Thread.currentThread().getId());
            }
        }).start();
    }
    
    public void criaThreads(int total) {
        for (int i = 0; i < total; i++) {
            t();
        }
    }
        
    public static void main(String[] args) {
        Threads t = new Threads();
        t.criaThreads(3);
    }
}
