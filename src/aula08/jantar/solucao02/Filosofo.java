package aula08.jantar.solucao02;

public class Filosofo implements Runnable{
    int id = 0;
    Resource garfo = null;

    public Filosofo(int initId, Resource initr) {
        id = initId;
        garfo = initr;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Filosofo " + id + " pensando");
                Thread.sleep(30);
                System.out.println("Filosofo " + id + " com fome");
                garfo.pegar(id);
                System.out.println("Filosofo " + id + " comendo");
                Thread.sleep(40);
                garfo.soltar(id);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
