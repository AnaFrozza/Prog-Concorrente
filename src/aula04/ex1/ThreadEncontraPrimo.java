/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04.ex1;

import java.util.List;

/**
 *
 * @author frozza
 */
public class ThreadEncontraPrimo {

    public boolean isPrimo(int valor) {
        int count = 0;
        if (valor != -1) {
            for (int i = 1; i <= valor; i++) {
                if (valor % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println("Numero Primo: " + valor);
                return true;
            }
        }
        return false;
    }

    public ThreadEncontraPrimo(Intervalo intervalo, List<Integer> resposta) {
        int valor = intervalo.next();
        boolean p = isPrimo(valor);
        System.out.println(p);

        if (p) {
            resposta.add(valor);
        }
    }

}
