package aula11.parte2.ex1;

/**
 *
 * @author frozza
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Faça um programa usando Threads e ConcorrenteMap para
 * calcular a frequência de cada letra em um texto.
 * */


public class ConcorrenteMap {
    static String local = "texto.txt";
    static int linhasToSerach = 3;
    static int numTasks = 10;


    public static void main(String[] args) {
        try {
            ConcorrenteMap letters = new ConcurrentHashMap<>();
            ExecutorService threadPool = Executors.newFixedThreadPool(numTasks);
            ArrayList<Future> listTarefas =  new ArrayList<>();

            Scanner file = new Scanner(new FileReader(local));


            int countLinha = 0;
            String conteudo = "";


            while(file.hasNext()){
                if(countLinha >= linhasToSerach){
                    Task_CountLetters task = new Task_CountLetters(conteudo, letters);
                    Future future = threadPool.submit(task);
                    listTarefas.add(future);

                    countLinha = 0;
                    conteudo = "";
                }
                conteudo += file.nextLine();
                countLinha++;
            }

            System.out.println("Esperando Conclusão das Tarefas...");
            for(Future ft : listTarefas){
                while(!ft.isDone()){
                    Thread.sleep(1000);
                }
            }

            System.out.println("Resultado: ");
            for(String key : letters.keySet()){
                System.out.println(key+" "+letters.get(key));
            }

            System.out.println("EndCode!");
            threadPool.shutdown();

        } catch (FileNotFoundException | InterruptedException ex) {
            Logger.getLogger(ConcorrenteMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}




