package aula11.parte1.ex02;

import java.util.ArrayList;

public class Baralho {

    String[] naipes;
    String[] valores;
    ArrayList<Carta> decl;

    public Baralho(String[] naipes, String[] valores, ArrayList<Carta> decl) {
        this.naipes = naipes;
        this.valores = valores;
        this.decl = decl;
    }


    public void create_Deck(){
        for(String naipe : this.naipes){
            for(String valor : this.valores){
                Carta carta = new Carta(naipe,valor);
                this.decl.add(carta);
            }
        }

        System.out.println("End Create Deck!");
    }

    public static void main(String[] args) {
        String[] naipes = new String[]{"Paus", "Copas", "Espadas", "Ouros"};
        String[] valores = new String[]{"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        ArrayList<Carta> decl = new ArrayList<>();

        Baralho bar = new Baralho(naipes, valores, decl);

    }
}
