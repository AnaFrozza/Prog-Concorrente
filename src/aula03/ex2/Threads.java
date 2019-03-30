/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.ex2;

/**
 *
 * @author frozza
 */

/**Faça um programa que receba um valor indicando um número de threads a serem instanciadas e teste 
 * os dois modos de criar threads em Java.
 * dica: use o Thread.sleep para pausar as threads por um intervalo de tempo.
*/

public class Threads {
    
    public static void main(String[] args) throws InterruptedException {
        
        Runnable r = new HelloRunnable();
        Thread runnable = new Thread(r);
        runnable.start();
        Thread.sleep(10);
        
        Thread subclasse = new HelloThread();
        subclasse.start();
        
    }
}
