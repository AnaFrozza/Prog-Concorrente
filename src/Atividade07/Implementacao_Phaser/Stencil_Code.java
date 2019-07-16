package Atividade07.Implementacao_Phaser;

import java.util.Arrays;
import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stencil_Code extends Thread {
    double[] vetor;
    int iteracoes;
    int numThreads;

    Phaser phaserblock;

    public Stencil_Code(double[] vetor, int iteracoes) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.phaserblock = new Phaser(2);
    }

    @Override
    public void run(){
        int count_itera = 0;

        while (count_itera <= this.iteracoes) {
            Implements_Phaser_Divisor tarefa01 = new Implements_Phaser_Divisor(1, vetor, phaserblock);
            Implements_Phaser_Divisor tarefa02 = new Implements_Phaser_Divisor(2, vetor, phaserblock);

            Thread thr01 = new Thread(tarefa01);
            Thread thr02 = new Thread(tarefa02);


            thr01.start();
            thr02.start();

            this.phaserblock.awaitAdvance(this.phaserblock.getPhase());

            count_itera++;
        }
    }

    public static void main(String[] args) {
        double[] vetor = new double[]{1, 65, 65, 1};

        Stencil_Code threadPrincipal = new Stencil_Code(vetor, 5000);
        threadPrincipal.start();

        try {
            threadPrincipal.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Stencil_Code.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(Arrays.toString(vetor));
    }
}
