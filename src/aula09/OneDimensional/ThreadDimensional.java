/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula09.OneDimensional;

/**
 *
 * @author frozza
 */
public class ThreadDimensional extends Thread {
    OneDimensional one;
    
    @Override
    public void run() {
        while (true) {
            calc(this.one.vetor1, this.one.vetor2);
            sleep(1000);
        }
    }
    
    public void calc(float v1[], float v2[]){
        v2[0] = v1[0];
        for (int i = 1; i < v1.length; i++) {
            v2[i] = (v1[i-1] + v1[i+1]) / 2;
        }
        v2[v1.length] = v1[v1.length];
    }

    public void sleep(int var) {
        try {
            Thread.sleep(var);
        } catch (InterruptedException ex) {
            System.out.println("Erro: " + ex);
        }
    }

}
