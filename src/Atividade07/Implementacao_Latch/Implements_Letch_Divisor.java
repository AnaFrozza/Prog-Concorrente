package Atividade07.Implementacao_Latch;

import java.util.concurrent.CountDownLatch;

public class Implements_Letch_Divisor extends Thread {
    int position;
    double[] vetor;
    CountDownLatch doneSignal;

    public Implements_Letch_Divisor(int position, double[] vetor, CountDownLatch doneSignal) {
        this.position = position;
        this.vetor = vetor;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;

            this.vetor[this.position] = valor;
        }
        this.doneSignal.countDown();
    }
}
