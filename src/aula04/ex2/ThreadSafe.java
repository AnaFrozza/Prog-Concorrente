/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04.ex2;

/**
 *
 * @author frozza
 */
/**
 * Modifique o código para garantir que será thread-safe Implemente três
 * versões: Usando Atomic, sincronizando o método e sincronizando o bloco.
 */
public class ThreadSafe extends Thread {

    public static void main(String[] args) {
        long startTime;
        long endTime;

        startTime = System.nanoTime();
        Lista lista_atom = new Lista(1, 10000000, 6);
        lista_atom.numeroPrimoByAtomic();
        endTime = System.nanoTime() - startTime;
        System.out.println("Tempo Total com Atomic: " + (endTime / 1000) + "ns");

//        startTime = System.nanoTime();
//        Lista lista_metod = new Lista(1, 10000000, 6);
//        lista_metod.numeroPrimoByMetod();
//        endTime = System.nanoTime() - startTime;
//        System.out.println("Tempo Total com Metodo: " + (endTime / 1000) + "ns");
//
//        startTime = System.nanoTime();
//        Lista lista_bloc = new Lista(1, 10000000, 6);
//        lista_bloc.numeroPrimoByBloc();
//        endTime = System.nanoTime() - startTime;
//        System.out.println("Tempo Total com Bloco: " + (endTime / 1000) + "ns");
    }
}
