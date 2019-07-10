package aula09.ex02;

import java.util.Random;

public class Produtor extends Thread {
    SharedFifoQueue share;
    Random gerador;

    public Produtor(SharedFifoQueue share) {
        this.share = share;
        this.gerador = new Random();
    }

    @Override
    public void run() {
        int valor;
        while (true) {
            valor = this.gerador.nextInt(9)+1;
            share.setValorLista(valor);
            System.out.println("Valor Inserido: "+valor);
            sleep(valor);
        }

    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        }
    }
}
