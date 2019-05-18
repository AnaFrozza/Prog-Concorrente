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
/**
 * Escreva um monitor BoundedCounter que possui um valor mı́nimo e máximo A
 * classe possui dois métodos: increment() e decrement() Ao alcançar os limites
 * mı́nimo ou máximo, a thread que alcançou deve ser bloqueada.
 */
public class BoundedCounter {
    
    ThreadIncrement increment;
    ThreadDecrement decrement;

    int max;
    int min;
    int count;

    public BoundedCounter(int min, int max) {
        this.increment = new ThreadIncrement(this, 10);
        this.decrement = new ThreadDecrement(this, 5);
        this.min = min;
        this.max = max;
        this.count = (min + max) / 2;
    }

    public synchronized void increment() {
        while (this.count > this.max) {
            try {
                this.notify();
                this.wait();
            } catch (InterruptedException ex) {
                System.out.println("Erro: " + ex);
            }
        }

        this.notify();
        this.count++;
    }

    public synchronized void decrement() {
        while (this.count < this.min) {
            try {
                this.notify();
                this.wait();
            } catch (InterruptedException ex) {
                System.out.println("Erro: " + ex);
            }
        }

        this.count--;
    }
    
    public void init(){
        this.increment.start();
        this.decrement.start();
    }
    
    public int getCount(){
        return this.count;
    }
    
    public static void main(String[] args) {
        BoundedCounter b = new BoundedCounter(2, 12);
        b.init();
    }
    
}
