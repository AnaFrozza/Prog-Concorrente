/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04.ex1;

/**
 *
 * @author frozza
 */
public class Intervalo {
    int next;
    int inicio;
    int fim;
    
    public Intervalo(int i, int f) {
        inicio = i;
        fim = f;
    }
    
    public int next(){
        System.out.println("Next");
        if(inicio < fim){
            inicio ++;
           return inicio--;
        }
        return -1;
    }
}
