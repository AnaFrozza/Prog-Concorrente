/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.ex2;

/**
 *
 * @author frozza
 */
public class HelloRunnable implements Runnable{
        
    @Override
    public void run(){
        System.out.println("Olá Thread implements");
    }
    
}
