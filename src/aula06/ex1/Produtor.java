/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula06.ex1;

/**
 *
 * @author frozza
 */
public class Produtor extends Thread{

    public Produtor() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Produtor");
            }
        }).start();
    }
    
}
