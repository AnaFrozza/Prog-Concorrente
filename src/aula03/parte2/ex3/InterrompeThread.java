/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte2.ex3;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frozza
 */
/**
 * Faça um programa Java que envia interrupções para as threads dos exercícios
 * anteriores As threads devem fazer o tratamento dessas interrupções e realizar
 * uma finalização limpa.
 */
public class InterrompeThread extends Thread {
    
    public void sleep(int tempo) {
        try {
            System.out.println("Sleep");
            Thread.sleep(tempo);
            System.out.println("Up");

        } catch (InterruptedException ex) {
            Logger.getLogger(ClasseRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        
        Thread teste = new Thread(new ThreadLeitura());
        teste.start();

        sleep(1500);
        System.out.println("Interrompendo...");
        teste.interrupt();
        sleep(2500);
        System.out.println("Interrompendo...");
        teste.interrupt();

    }
    
    public static void main(String[] args) {
        InterrompeThread interrompeThread = new InterrompeThread();
        interrompeThread.run();
    }

}
