/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula09.ex01;

import java.util.concurrent.locks.Lock;

/**
 *
 * @author frozza
 */

/**
 * Faça um programa usando Lock para simular a atualização de
 * um contador que é acessado por múltiplas threads
 * O contador pode diminuir e aumentar.
 */

public class ThreadLock extends Thread{
    Lock l;
    int count = 0;
    
    
}
