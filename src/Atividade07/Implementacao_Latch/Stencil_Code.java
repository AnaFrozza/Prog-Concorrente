package Atividade07.Implementacao_Latch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stencil_Code extends Thread {
    double[] vetor;
    int iteracoes;
    int numThreads;

    CountDownLatch doneSignal;
    CountDownLatch done;

    public Stencil_Code(double[] vetor, int iteracoes, CountDownLatch done) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.done = done;
        this.doneSignal = new CountDownLatch(2);
    }

    @Override
    public void run(){
        int count_itera = 0;

        while (count_itera <= this.iteracoes) {
            try {


                Implements_Letch_Divisor thread01 = new Implements_Letch_Divisor(1, this.vetor, this.doneSignal);
                Implements_Letch_Divisor thread02 = new Implements_Letch_Divisor(2, this.vetor, this.doneSignal);

                thread01.start();
                thread02.start();

                this.doneSignal.await();
                count_itera++;
                this.doneSignal = new CountDownLatch(2);

            } catch (InterruptedException ex) {
                Logger.getLogger(Stencil_Code.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.done.countDown();
    }


    public static void main(String[] args) {
        double[] vetor = new double[]{1,2,2,1};
        CountDownLatch done = new CountDownLatch(1);
        Stencil_Code threadPrincipal = new Stencil_Code(vetor, 500, done);

        try {
            threadPrincipal.start();
            done.await();
            System.out.println(Arrays.toString(vetor));
        } catch (InterruptedException ex) {
            Logger.getLogger(Stencil_Code.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
