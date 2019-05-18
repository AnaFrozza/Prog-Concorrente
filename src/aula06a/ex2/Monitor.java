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
public class Monitor extends Thread{
    Threads t;
    
    public Monitor(Threads t){
        this.t = t;
    }
    
    @Override
    public void run(){
        while (true) {            
            this.t.sleepUntil();
        }
    }
    
    public void sleep(int var) {
        try {
            Thread.sleep(var);
            System.out.println("Thread acordou!");
        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        }
    }
}
