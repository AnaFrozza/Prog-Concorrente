/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula06.ex1;

import com.sun.corba.se.spi.monitoring.MonitoredObject;
import javax.management.monitor.Monitor;

/**
 *
 * @author frozza
 */

/**
 * Implemente o problema do produtor-consumidor que há um buffer compartilhado entre threads
 * Há uma única thread produtora e uma única consumidora
 * O buffer é preenchido em tempos aleatórios pela thread produtora
 * Assim que for produzido algo, a thread consumidora deve ser comunicada 
 * para obter o valor.
 */


public class Threads extends Thread{
    boolean sinal = false;
    int buffer;
    
    Consumidor consumidor = new Consumidor();
    Produtor produtor = new Produtor();
    
//    Aqui a Thread espera
    public void doWait(){
        synchronized(consumidor){
            while(!sinal){
                try{
                    consumidor.wait();
                }catch(InterruptedException e){
                    System.out.println("Erro: "+ e);
                }
            }
            
            sinal = false;
        }
    }
    
    
//    Chama a Thread que esta dormindo
    public void doNotify(){
        synchronized(consumidor){
            sinal = true;
            consumidor.notify();
        }
    }
    
    
    public static void main(String[] args) {
        
    }
}
