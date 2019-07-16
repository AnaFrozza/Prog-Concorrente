package Tarefa08.Framework.ex01;

import java.util.concurrent.Callable;

public class Tarefa_SerachBigger implements Callable<Integer> {
    int init;
    int fim;
    int[] vetor;

    public Tarefa_SerachBigger(int init, int fim, int[] vetor) {
        this.init = init;
        this.fim = fim;
        this.vetor = vetor;
    }

    @Override
    public Integer call() throws Exception {
        int maiorVal = this.vetor[this.init];

        for(int i=(this.init+1); i<this.fim; i++){
            if(maiorVal <= this.vetor[i]){
                maiorVal = this.vetor[i];
            }
        }
        return maiorVal;
    }
}
