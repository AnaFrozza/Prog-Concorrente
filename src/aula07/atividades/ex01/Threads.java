/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula07.atividades.ex01;

/**
 *
 * @author frozza
 */
public class Threads extends Thread{
    
    Sinalizacao sinal;
    String nome;
    
    public Threads(Sinalizacao sinal, String nome){
        this.sinal = sinal;
        this.nome = nome;
    }
    
    @Override
    public void run(){
        while(true){
            this.sinal.sinal(this.nome);
            System.out.println(this.nome +" indo dormir.");
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
