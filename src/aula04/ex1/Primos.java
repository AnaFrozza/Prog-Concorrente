/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04.ex1;

import java.util.List;

/**
 *
 * @author frozza
 */
/**
 * Faca um programa em Java que use Threads para encontrar os numeros primos
 * dentro de um intervalo 
 * O método que contabiliza os numeros primos deve possuir como entrada: 
 * valor inicial e final do intervalo, numero de threads.
 */
public class Primos extends Thread {
        
    public void calcIntervaloPrimo(int i, int f, int nThread){
        
//        Trava a logica no intervalo
        Intervalo intervalo = new Intervalo(i, f);
        
        List<Integer> respostas = null;
    
        for(int j = 0; j < nThread; j++){
            new ThreadEncontraPrimo(intervalo, respostas);
            
        }
    }
    
    public void criaThreads(int total) {
        for (int i = 0; i < total; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("id: " + Thread.currentThread().getId());
                    calcIntervaloPrimo(0, 10, 5);
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        Primos primo = new Primos();
        primo.criaThreads(5);

        System.exit(0);
    }
}
