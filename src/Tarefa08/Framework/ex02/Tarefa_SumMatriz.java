package Tarefa08.Framework.ex02;

import java.util.concurrent.Callable;

public class Tarefa_SumMatriz implements Callable<Integer> {

    int linha;
    int tamColuna;
    int[][] matriz;

    public Tarefa_SumMatriz(int linha, int tamColuna, int[][] matriz) {
        this.linha = linha;
        this.tamColuna = tamColuna;
        this.matriz = matriz;
    }

    @Override
    public Integer call() throws Exception {
        int somaColuna=0;

        for(int i=0;i<this.tamColuna;i++){
            somaColuna += this.matriz[this.linha][i];
        }

        return somaColuna;
    }
}
