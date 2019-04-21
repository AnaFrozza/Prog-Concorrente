/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte3.ex2;

/**
 *
 * @author frozza
 */
/**
 * Faça um programa em Java para testar um conjunto de operações sobre um grupo
 * de threads Use o ThreadGroup.
 */
public class GroupThread extends Thread {

    @Override
    public void run() {
        System.out.println("Grupo Thread ");
    }

    public static void main(String[] args) {

        ThreadGroup group = new ThreadGroup("MyThreadsGroup");

        Thread t1 = new Thread(group, new GroupThread());
        Thread t2 = new Thread(group, new GroupThread());
        Thread t3 = new Thread(group, new GroupThread());
        Thread t4 = new Thread(group, new GroupThread());
        Thread t5 = new Thread(group, new GroupThread());
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }
}
