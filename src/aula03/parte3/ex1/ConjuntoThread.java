/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte3.ex1;

/**
 *
 * @author frozza
 */
public class ConjuntoThread extends Thread {

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println("Erro: "+ex);
        }
    }

}
