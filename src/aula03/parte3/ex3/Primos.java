/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte3.ex3;

/**
 *
 * @author frozza
 */
/**
 * Faça um programa em Java com threads que exiba os números primos entre 0 e
 * 100000.
 */
public class Primos extends Thread {
    
    int valor = 0;
    
    public Primos(int valor){
        this.valor = valor;
    }
    
    public void run() {
        int count = 0;
        boolean isPrimo = false;
        
        if (valor != -1) {
            for (int i = 1; i <= valor; i++) {
                if (valor % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println("Numero Primo: " + valor);
                isPrimo = true;
            }
        }
        isPrimo = false;
    }
    
    public static void main(String[] args) {
        Primos thread;
        for(int i = 0; i < 100000; i++){
            thread = new Primos(i);
            thread.start();
        }
    }
}
