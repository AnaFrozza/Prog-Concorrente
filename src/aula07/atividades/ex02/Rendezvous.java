/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula07.atividades.ex02;

import java.util.concurrent.Semaphore;

/**
 *
 * @author frozza
 */

/**
 * Enviar sinalização para um ponto de encontro entre threads
 * Faça um código que uma thread t1 e t2 são inicializadas e t1 espera por t2 e vice-versa
 * Exemplo:
 *      t1:
 *          trecho1
 *          trecho1.2
 *      t2:
 *          trecho2.1
 *          trecho2.2
 * 
 * thecho1.1 ocorre antes trecho2.2 e threcho2.1 ocorre antes de trecho1.2.
 */

public class Rendezvous {
    Semaphore semaforo;
    Trecho t1;
    Trecho t2;
    
    public Rendezvous(){
        this.semaforo = new Semaphore(1);
        this.t1 = new Trecho(this, "trecho1");
        this.t2 = new Trecho(this, "trecho2");
    }
    
    public void trecho(String trecho){
        try{
            System.out.println(trecho);
            this.semaforo.acquire();
            
        }catch(InterruptedException ex){
            System.out.println("Erro: "+ex);
        }
    }
    
    public void init(){
        this.t1.start();
        this.t2.start();
    }
    
    public static void main(String[] args) {
        Rendezvous rende = new Rendezvous();
        rende.init();
    }
}
