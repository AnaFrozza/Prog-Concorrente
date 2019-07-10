package aula09.ex03;

import java.util.Random;

public class Escritor extends Thread {
    ArrayListThreadSafe threadSafe;
    Random gerador;

    public Escritor(ArrayListThreadSafe threadSafe) {
        this.threadSafe = threadSafe;
        this.gerador = new Random();
    }

    @Override
    public void run() {
        while (true) {
            this.threadSafe.escrever("a ");
            System.out.println("Escritor> a");
            sleep((gerador.nextInt(9)+1)*1000);
        }

    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            System.out.println("ERRO: "+ex);
        }
    }
}
