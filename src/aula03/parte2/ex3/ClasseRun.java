/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte2.ex3;

import aula03.parte1.ex1.RunnableLambda;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author frozza
 */
public class ClasseRun extends RunnableLambda{

    public void run() {
        System.out.println("SleepRun");
        try {
            Thread.sleep(6000);
            System.out.println("WakeUpRun");
        } catch (InterruptedException ex) {
            Logger.getLogger(ClasseRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
