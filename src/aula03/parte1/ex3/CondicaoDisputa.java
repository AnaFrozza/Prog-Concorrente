/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte1.ex3;

/**
 *
 * @author frozza
 */
/**
 * Implemente o exemplo de código que gera a condição de disputa e tente gerar
 * um teste para que ocorra um problema de segurança (safety).
 */
public class CondicaoDisputa extends Thread {

    private long count;
    private long maxValue;

    public static void main(String[] args) {
        CondicaoDisputa cd = new CondicaoDisputa(10);
        cd.criaThreads(5);

    }

    public void criaThreads(int total) {
        for (int i = 0; i < total; i++) {
            t();
        }
    }

    public CondicaoDisputa(long maxValue) {
        this.maxValue = maxValue;
    }

    private long incrementa() {
        return ++count;
    }

    private void t() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                soma(Thread.currentThread().getId() + "");
                System.out.println("=========================================================");
            }
        }).start();
    }

    private void soma(String id) {
        for (long i = 0; i < this.maxValue; i++) {
//            double a = i * Math.PI * count;
            System.out.println(incrementa() + " - Thread " + id);

        }
    }
}
