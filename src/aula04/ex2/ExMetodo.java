/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04.ex2;

/**
 *
 * @author frozza
 */
public class ExMetodo extends Thread {

    Lista lista;

    public ExMetodo(Lista lista, ThreadGroup tg, String tIndex) {
        super(tg, tIndex);
        this.lista = lista;
    }

    @Override
    public void run() {
        int num;
        int count;

        while (this.lista.getIndex().get() < this.lista.getTam()) {
            num = this.lista.getNumByIndex();
            count = 0;
            if (num != -1) {
                for (int i = 0; i < num; i++) {
                    if(num % i == 0){
                        count ++;
                    }
                }
                
                if(count == 2){
                    System.out.println("O numero é primo. \n");
                }
                
                sleep(100);
            }
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
