/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.parte2.ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frozza
 */
/**
 * Faça uma thread Java que realize a leitura de um arquivo texto com frases e
 * exiba as frases a cada 10 segundos.
 */
public class ThreadLeitura extends Thread {

    public void criaThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {                
                File arquivo = new File("/home/frozza/NetBeansProjects/ProgConcorrente/src/aula03/parte2/ex2/arquivo.txt");
        
                try{
                    if(arquivo.exists()){
                       FileReader fr = new FileReader(arquivo);
                       BufferedReader br = new BufferedReader(fr);
                       
                       while(br.ready()){
                           String line = br.readLine();
                           Thread.sleep(10000);
                           System.out.println(line);
                       }
                       
                       br.close();
                       fr.close();
                       
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void main(String[] args) {
        ThreadLeitura tl = new ThreadLeitura();
        tl.criaThread();
    }
}
