package aula08.escritorleitor;

/**
 *
 * @author frozza
 */


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementar soluções para o problema dos leitores-escritores
 *
 * */


public class BufferSimples {
    String texto;
    int leitores;

    Semaphore canWrite;
    Semaphore mutex;

    public BufferSimples() {
        this.canWrite = new Semaphore(1);
        this.mutex = new Semaphore(1);

        this.leitores = 0;
        this.texto = "initi: ";
    }

    public void lerArquivo() {

        try {
            this.mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(BufferSimples.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.leitores++;
        try {
            if (this.leitores == 1) {
                this.canWrite.acquire();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(BufferSimples.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Ler: " + this.texto);

        this.leitores--;
        if (this.leitores == 0) {
            this.canWrite.release();
        }
        this.mutex.release();

    }

    public void escreverArquivo() {
        try {
            this.canWrite.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(BufferSimples.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.texto += " oi";
        this.canWrite.release();
    }

    public static void main(String[] args) {
        BufferSimples bs = new BufferSimples();
        bs.escreverArquivo();
        bs.lerArquivo();

        System.out.println("Concluido");
    }

}
