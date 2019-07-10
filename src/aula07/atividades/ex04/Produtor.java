package aula07.atividades.ex04;

import java.nio.Buffer;
import java.util.Random;

public class Produtor extends Thread {
    Buffer buffer;

    public Produtor(Buffer buff) {
        this.buffer = buff;
    }

    @Override
    public void run() {
        Random gerador = new Random();
        int number;

        while (true) {
            number = gerador.nextInt(10)+1;
            sleep(number);
        }
    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
            System.out.println("Thread Produtor Acordou!");
        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        }

    }

}
