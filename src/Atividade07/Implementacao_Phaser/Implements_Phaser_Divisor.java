package Atividade07.Implementacao_Phaser;

import java.util.concurrent.Phaser;

public class Implements_Phaser_Divisor implements Runnable {
    int position;
    double[] vetor;

    Phaser phaserblock;

    public Implements_Phaser_Divisor(int position, double[] vetor, Phaser phaserblock) {
        this.position = position;
        this.vetor = vetor;
        this.phaserblock = phaserblock;
    }

    @Override
    public void run() {
        if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;

            this.vetor[this.position] = valor;
        }
        this.phaserblock.arrive();
    }
}
