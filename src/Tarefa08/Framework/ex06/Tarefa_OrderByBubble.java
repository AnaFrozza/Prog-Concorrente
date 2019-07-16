package Tarefa08.Framework.ex06;

import java.util.concurrent.Callable;

public class Tarefa_OrderByBubble implements Callable<DadosVetor> {

    int[] v;
    DadosVetor dadosVetor;


    public Tarefa_OrderByBubble(int[] vet) {
        this.v = vet;
        this.dadosVetor = new DadosVetor();
    }

    @Override
    public DadosVetor call() throws Exception {

        for (int i = v.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }

        this.dadosVetor.setNomeFunc("BubbleSort");
        this.dadosVetor.setVet(this.v);
        return this.dadosVetor;
    }
}
