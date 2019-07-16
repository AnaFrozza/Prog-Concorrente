package Tarefa08.Framework.ex03;

/**
 * Ana Frozza
 *
 * */


import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Faça um programa concorrente para multiplicar duas matrizes.
 * */

public class MultiplicaMatriz {
    int[][] matriz01;
    int[][] matriz02;
    int sizeXY;
    int[][] matrizResult;
    ArrayList<Future<Integer>> listTarefas;
    ExecutorService threadPool;

    public MultiplicaMatriz(int[][] matriz01, int[][] matriz02, int sizeXY) {
        this.matriz01 = matriz01;
        this.matriz02 = matriz02;
        this.sizeXY = sizeXY;

        this.threadPool = Executors.newFixedThreadPool(sizeXY);
        this.listTarefas = new ArrayList<>();
    }

    public void multiMatriz() {

        System.out.println("Inicializando Tarefas ...");
        for (int i = 0; i < this.sizeXY; i++) {
            for (int j = 0; j < this.sizeXY; j++) {

                Tarefa_MultiMatriz tarefa = new Tarefa_MultiMatriz(this.matriz01, this.matriz02, i, j, this.sizeXY);

                Future<Integer> future = this.threadPool.submit(tarefa);
                this.listTarefas.add(future);
            }
        }

        System.out.println("Aguardando Conclusão....");
        for (Future<Integer> ft : this.listTarefas) {
            while (!ft.isDone()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultiplicaMatriz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        int countAux = 0;
        for(Future<Integer> ft : this.listTarefas){
            try {
                System.out.print(" "+ft.get());
                countAux++;
                if(countAux >= this.sizeXY){
                    System.out.println();
                    countAux=0;
                }

            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(MultiplicaMatriz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        System.out.println("Matriz Resultado: ");
        for (int i = 0; i < this.sizeXY; i++) {
            for (int j = 0; j < this.sizeXY; j++) {
                System.out.print(" " + matrizResult[i][j]);
            }
            System.out.println();
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

        MultiplicaMatriz multiplicaMatriz = new MultiplicaMatriz(matriz, matriz, sizeX);
        multiplicaMatriz.multiMatriz();
    }
}
