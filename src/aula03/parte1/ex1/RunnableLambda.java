/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte1.ex1;

/**
 *
 * @author frozza
 */

//Implemente o exemplo anterior usando Lambda Expression.

public class RunnableLambda {
    
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Olá Thread Lambda");
        };
        new Thread(task).start();
    }
    
}
