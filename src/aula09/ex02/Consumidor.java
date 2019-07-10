package aula09.ex02;

public class Consumidor extends Thread{
    SharedFifoQueue shared;

    public Consumidor(SharedFifoQueue shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        int valor;
        while (true) {
            valor = this.shared.getValorLista();
            System.out.println("Valor Removido: "+valor);
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
