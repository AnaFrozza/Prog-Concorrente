package aula10.parte1.ex02;

/**
 *
 * @author frozza
 */

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implemente um programa que calcule o fatorial de um número
 * em uma thread usando o Callable.
 * */


public class Fatorial implements Callable<Integer> {
    int n;

    public Fatorial(int n) {
        this.n = n;
    }



    @Override
    public Integer call() throws Exception {
        int result=1;

        for (int i = 1; i <= this.n; i++) {
            result = result * i;
        }

        return result;
    }

    public static void main(String[] args) {
        Fatorial fat =  new Fatorial(5);
        try {
            System.out.println("Resultado: "+fat.call());
        } catch (Exception ex) {
            Logger.getLogger(Fatorial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
