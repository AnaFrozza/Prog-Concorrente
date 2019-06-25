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


public class OneDimensional {
    float vetor1[];
    float vetor2[];
    
    public static void main(String[] args) {
        ThreadDimensional t = new ThreadDimensional();
        OneDimensional one = new OneDimensional();
        one.vetor1[0] = 1;
        one.vetor1[1] = 2;
        one.vetor1[2] = 2;
        one.vetor1[3] = 1;
        
//        t.run();
        for(int i = 0; i < one.vetor1.length; i++){
            System.out.println(one.vetor1[i]);
        }        
    }
}
