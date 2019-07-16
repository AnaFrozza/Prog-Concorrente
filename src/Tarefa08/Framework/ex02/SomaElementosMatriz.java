package Tarefa08.Framework.ex02;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Faça um programa que calcule a soma dos elementos de uma matriz
 *     MxN. Divida o programa em tarefas que somam as linhas. O programa
 *     deve possibilitar especificar o número de threads para resolver o problema.
 *
 * */

public class SomaElementosMatriz {
    int[][] matriz;
    int numThreads;
    int sizeX;
    int sizeY;
    ArrayList<Future<Integer>> listTarefas;
    ExecutorService threadPool;


    public SomaElementosMatriz(int[][] matriz, int numThreads, int sizeX, int sizeY) {
        this.matriz = matriz;
        this.numThreads = numThreads;
        this.listTarefas = new ArrayList<>();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.threadPool = Executors.newFixedThreadPool(numThreads);
    }

    public void sumMatriz(){
        int posicao_Linha = 0;
        int somaTotal=0;

        while(posicao_Linha < this.sizeX){
            Tarefa_SumMatriz tarefa = new Tarefa_SumMatriz(posicao_Linha, this.sizeY, this.matriz);
            Future<Integer> future = this.threadPool.submit(tarefa);

            this.listTarefas.add(future);
            posicao_Linha++;
        }

        for(Future<Integer> ft : this.listTarefas){
            while(!ft.isDone()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SomaElementosMatriz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        for(Future<Integer> ft : this.listTarefas){
            try {
                somaTotal += ft.get();
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(SomaElementosMatriz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.threadPool.shutdown();
        System.out.println("Soma Total: "+somaTotal);

    }

    public static void main(String[] args) {
        Random random = new Random();

        //Inicializar vetor
        int tamVet = 99999999;
        int[] vetor = new int[tamVet];

        for(int i=0;i<tamVet;i++){
            vetor[i] = random.nextInt(999999999);
        }

        //Inicializar matriz
        int sizeX = 1000;
        int sizeY = 1000;
        int[][] matriz = new int[sizeY][sizeY];

        for(int i=0;i<sizeX;i++){
            for(int j=0;j<sizeY;j++){
                matriz[i][j] = random.nextInt(999);
            }
        }

        SomaElementosMatriz somaElementos = new SomaElementosMatriz(matriz, 10, sizeX, sizeY);
        somaElementos.sumMatriz();
    }
}
