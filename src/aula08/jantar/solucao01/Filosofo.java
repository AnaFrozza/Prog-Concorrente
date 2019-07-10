package aula08.jantar.solucao01;

public class Filosofo implements Runnable{
    int id = 0;
    Resource resource = null;

    public Filosofo(int initId, Resource initr) {
        id = initId;
        resource = initr;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Filosofo " + id + " pensando");
                Thread.sleep(30);
                System.out.println("Filosofo " + id + " com fome");
                resource.pegar(id);
                System.out.println("Filosofo " + id + " comendo");
                Thread.sleep(40);
                resource.soltar(id);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
