/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula07.atividades.ex02;

/**
 *
 * @author frozza
 */
public class Trecho extends Thread{
    Rendezvous rende;
    String nome;
    int trecho;
    
    public Trecho(Rendezvous rende, String nome){
        this.rende = rende;
        this.nome = nome;
        this.trecho = 0;
    }
    
    @Override
    public void run(){
        while (true) {            
            this.trecho++;
            rende.trecho(this.nome+"."+this.trecho);
            this.sleep(1000);
        }
    }
    
    public void sleep(int var){
        try{
            Thread.sleep(var);
        }catch(InterruptedException ex){
            System.out.println("Erro: "+ex);
        }
    }
}
