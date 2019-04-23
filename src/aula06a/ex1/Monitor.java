/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula06a.ex1;

/**
 *
 * @author frozza
 */
/**
 * Implemente uma solução com monitor para o problema do Produtor-Consumidor
 * usando um buffer circular.
 */
public class Monitor extends Thread{

    private String buffer;
    private boolean empty = true;

    private final Object objMonitor = new Object();

    public String take() {
        synchronized (objMonitor) {
            while (empty) {
                try {
                    objMonitor.wait();
                } catch (Exception e) {
                    System.out.println("Erro: " + e);
                }
            }
            empty = true;
            objMonitor.notifyAll();
            return buffer;
        }
    }

    public void put(String message) {
        synchronized (objMonitor) {
            while (!empty) {
                try {
                    objMonitor.wait();
                } catch (Exception e) {
                    System.out.println("Erro: "+e);
                }
            }
            empty = false;
            buffer = message;
            objMonitor.notifyAll();
            System.out.println(buffer);
        }
    }

    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        monitor.buffer = "olaMonitor";
        monitor.put(monitor.take());
        
        System.out.println("Concluido!");
        
        System.exit(0);
    }
}