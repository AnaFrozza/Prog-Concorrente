/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte3.ex5;

/**
 *
 * @author frozza
 */
/**
 * Faça um programa multithreaded em Java que ordene um vetor usando o Merge
 * Sort recursivo Faça com que a thread principal dispare duas threads para
 * classificar cada metade do vetor.
 */


public class Threads extends Thread{
    int minimo;
    int maximo;
    int[] vetor;
    
    public Threads(int minimo, int maximo, int[] vetor){
        this.minimo = minimo;
        this.maximo = maximo;
        this.vetor = vetor;
    }
    
    @Override
    public void run(){
        MergeSort merge = new MergeSort();
        merge.mergeSort(vetor, minimo, maximo);
    }
    
    public static void main(String[] args) {
        int[] vetor = new int[1000];
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = i+1;
        }
        Threads t1 = new Threads(0, 500, vetor);
        Threads t2 = new Threads(500, 1000, vetor);
        Threads t3 = new Threads(0, 1000, vetor);
        
        try{
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        }catch(Exception ex){
            System.out.println("Erro: "+ex);
        }
        
        System.out.println("Vetor ordenado:");
        for(int i = 0; i < vetor.length; i++){
            System.out.println(" "+vetor[i]);
        }
    }
}
