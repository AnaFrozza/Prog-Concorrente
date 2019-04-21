/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte2.ex5;

import java.util.Scanner;

/**
 *
 * @author frozza
 */
/**
 * Faça uma thread Java que fica aguardando uma sequência numérica de tamanho
 * arbitrário digitado por usuário para realizar uma soma Use o join().
 */
public class ThreadSoma extends Thread {

    static int valor;

    public ThreadSoma(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void sleep(int tempo) {
        try {
            System.out.println("Sleep");
            Thread.sleep(tempo);
            System.out.println("Up");

        } catch (InterruptedException ex) {
            System.out.println("Erro: " + ex);
        }
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            valor = scanner.nextInt();
            sleep(3000);
            throw new InterruptedException();
            
        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int soma = 0;
        
        System.out.println("Informe um valor: ");
        ThreadSoma thread = new ThreadSoma(soma);
        thread.start();
        
        thread.join();
        
        System.out.println("Concluido...");
        
        System.exit(0);
    }
}
