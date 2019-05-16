/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte3.ex4;

/**
 *
 * @author frozza
 */
/**
 * Faça um programa em Java que realize uma busca paralela em um vetor de
 * inteiros Informe para o método: valor procurado, vetor de inteiros e o número
 * de threads.
 */
public class Busca extends Thread {

    int valor;
    int[] vetor;
    int num_threads;

    public Busca(int valor, int[] vetor, int num_threads) {
        this.valor = valor;
        this.vetor = vetor;
        this.num_threads = num_threads;

    }

    @Override
    public void run() {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor) {
                System.out.println("Valor encontrado: " + valor);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] list = null;
        int valor = 20;
        int num_threads = 5;
        
        for(int i = 0; i < 50 ; i++){
            list[i] = i;
        }
        
        for(int i = 0; i < num_threads; i++){
            Busca busca = new Busca(valor, list, num_threads);
            busca.start();
        }
    }

}
