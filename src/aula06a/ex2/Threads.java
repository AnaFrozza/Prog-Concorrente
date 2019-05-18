/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula06a.ex2;

/**
 *
 * @author frozza
 */


/**
 * Escreva uma monitor Counter que possibilita um processo
 * dormir até o contador alcançar um valor
 * A classe Counter permite duas operações: 
 * increment() e sleepUntil(int x).
 */

public class Threads {
    int count;
    int hora_acordar;
    Monitor monitor;
    
    
    public Threads(int tempo){
        this.count = 0;
        this.monitor = new Monitor(this);
        this.hora_acordar = tempo;
    }
    
    public synchronized void increment(){
        this.count ++;
    }
    
    public synchronized void sleepUntil(){
        System.out.println("Thread dormiu!\n");
        while(this.count <= this.hora_acordar){
            this.monitor.sleep(1000);
            increment();
        }
        
        System.out.println("Thread acordou!");
        this.count = 0;
    }
    
    public void init(){
        this.monitor.start();
    }
    
    public static void main(String[] args) {
        Threads t = new Threads(5);
        t.init();
    }
}
