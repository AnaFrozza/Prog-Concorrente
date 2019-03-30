/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.ex3;

/**
 *
 * @author frozza
 */
/**
 * Implemente o exemplo de código que gera a condição de disputa e tente gerar
 * um teste para que ocorra um problema de segurança (safety).
 */
public class CondicaoDisputa extends Thread{

    Contador cont;

//    public insereThread(Contador cont) {
//        this.cont = cont;
//        
//    }

    public static void main(String[] args) {
        CondicaoDisputa condicaoDisputa = new CondicaoDisputa();
        Contador contador = condicaoDisputa.cont;
        
        
        
        System.out.println(contador);
    }
}
