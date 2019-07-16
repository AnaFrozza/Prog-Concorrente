package Tarefa08.Framework.ex06;

/**
 * Ana Frozza
 * */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Faça um programa que execute três algoritmos de ordenação para um
 *     conjunto de valores e exiba o resultado apenas do algoritmo que finalizar
 *     primeiro (use invokeAny ).
 *     */

public class Ordenacao {
    Collection<Callable<DadosVetor>> listTarefas;

    ExecutorService threadPool;
    int[] vet;

    public Ordenacao(int[] vetorInt) {
        this.listTarefas = new ArrayList<>();
        this.threadPool = Executors.newFixedThreadPool(3);
        this.vet = vetorInt;
    }

    public void init() {
        Tarefa_OrderByBubble bubb = new Tarefa_OrderByBubble(this.vet);
        Tarefa_OrderByHeap heap = new Tarefa_OrderByHeap(this.vet);
        Tarefa_OrderByQuick quick = new Tarefa_OrderByQuick(this.vet);

//        Future<Integer[]> future01 = this.threadPool.submit(bubb);
//        Future<Integer[]> future02 = this.threadPool.submit(heap);
//        Future<Integer[]> future03 = this.threadPool.submit(quick);
//
        this.listTarefas.add(bubb);
        this.listTarefas.add(heap);
        this.listTarefas.add(quick);

        DadosVetor dados = null;

        while (dados == null) {
            try {
                dados = this.threadPool.invokeAny(this.listTarefas);
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Ordenacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Uma Tarefa Concluida!");
        System.out.println("Tipo da Busca: " + dados.getNomeFunc());

        for (int i = 0; i < dados.getVet().length; i++) {
            System.out.print(" " + dados.getVet()[i]);
        }

        this.threadPool.shutdown();
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
        Ordenacao ordenacao = new Ordenacao(vetor);
        ordenacao.init();
    }
}
