    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04.ex2;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author frozza
 */
public class Lista {
    ArrayList<Integer> lista;
    
    AtomicInteger index;
    int min;
    int max;
    int num;
    int tam;
    ThreadGroup threadGroup;

    public Lista(int inicio, int fim, int numThread) {
        this.index = new AtomicInteger();
        
        this.max = fim;
        this.min = inicio;
        this.num = numThread;
        this.threadGroup = new ThreadGroup("GrupoAna");
        
        this.lista = new ArrayList<>();
        
        for(int i = 0; i < max; i++){
            this.lista.add(i);
        }
        
        this.tam = this.lista.size();
    }
    
    public AtomicInteger getIndex(){
        return this.index;
    }
    
    public int getNumByIndex(){
        this.index.addAndGet(1);
        if(this.index.get() == this.lista.size()){
            return -1;
        } else {
            return this.lista.get(this.index.get());
        }
    }
    
    public int getTam(){
        return this.tam;
    }
    
    public void numeroPrimoByAtomic(){
        for(int i = 0; i < this.num ; i++){
            ExAtomic t = new ExAtomic(this, this.threadGroup, "thread"+i);            
            t.start();
        }
    }
    
    public void numeroPrimoByMetod(){
        for(int i = 0; i < this.num ; i++){
            ExMetodo t = new ExMetodo(this, this.threadGroup, "thread"+i);            
            t.start();
        }
    }
    
    public void numeroPrimoByBloc(){
        for(int i = 0; i < this.num ; i++){
            ExBloco t = new ExBloco(this, this.threadGroup, "thread"+i);            
            t.start();
        }
    }
}
