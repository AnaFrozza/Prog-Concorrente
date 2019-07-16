package Atividade07.Implementacao_CyclicBarrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stencil_Code extends Thread {
    double[] vetor;
    int iteracoes;
    int numThreads;
    int count_itera;

    CyclicBarrier doneBarrier;

    public Stencil_Code(double[] vetor, int iteracoes) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.count_itera = 0;
        this.doneBarrier = new CyclicBarrier(2,new EstouroBarreira(this));
    }

    @Override
    public void run(){
        while (this.count_itera <= this.iteracoes) {
            Implements_CyBarrier_Divisor tarefa01 = new Implements_CyBarrier_Divisor(1, this.vetor, this.doneBarrier);
            Implements_CyBarrier_Divisor tarefa02 = new Implements_CyBarrier_Divisor(2, this.vetor, this.doneBarrier);

            Thread th01 = new Thread(tarefa01);
            Thread th02 = new Thread(tarefa02);

            th01.start();
            th02.start();

            try {
                th01.join();
                th02.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Stencil_Code.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.doneBarrier.reset();
        }
    }

    public static void main(String[] args) {
        double[] vetor = new double[]{1, 2, 2, 1};

        Stencil_Code threadPrincipal = new Stencil_Code(vetor, 500);

        threadPrincipal.start();

        try {
            threadPrincipal.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Stencil_Code.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(Arrays.toString(vetor));
    }
}
