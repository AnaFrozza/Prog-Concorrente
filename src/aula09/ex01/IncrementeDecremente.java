package aula09.ex01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class IncrementeDecremente extends Thread {
    ThreadLock threadLock;
    boolean increase;


    public IncrementeDecremente(ThreadLock threadLock, boolean increase) {
        this.threadLock = threadLock;
        this.increase =  increase;
    }

    @Override
    public void run() {
        while(true){
            this.threadLock.incrementeDecremente(this.increase);
            this.threadLock.verValor();
            //sleep(2000);
        }
    }



    public void sleep(int val) {
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
