/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula10.ex01;

/**
 *
 * @author frozza
 */
/**
 * Implemente um programa que calcule o fatorial de um número em uma thread
 * usando o Runnable.
 */
public class Task implements Runnable {
    private int result;
    private int valor;
    
    public int fatorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * fatorial(num - 1);
        }
    }
    
    public int getReturn(){
        return result;
    }

    @Override
    public void run() {
        result = fatorial(valor);
    }

    public static void main(String[] args) throws InterruptedException {
        Task t = new Task();
        Thread tr = new Thread(t);
        t.valor = 5;
        tr.start();
        tr.join();
        System.out.println("!"+ t.valor +" = "+t.result);
        
    }
}
