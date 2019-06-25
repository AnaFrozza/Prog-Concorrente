/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11.ex01;

/**
 *
 * @author frozza
 */
public class Consumidor extends Thread{
    public Consumidor() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Consumidor");
            }
        }).start();
    }
}
