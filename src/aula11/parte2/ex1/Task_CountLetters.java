package aula11.parte2.ex1;

public class Task_CountLetters implements Runnable {

    ConcorrenteMap letters;
    String conteudo;

    public Task_CountLetters(String conteudo, ConcorrenteMap letters) {
        this.letters = letters;
        this.conteudo = conteudo;
    }

    @Override
    public void run() {
        for (char letra : this.conteudo.toCharArray()) {
            if (this.letters.containsKey(Character.toString(letra))) {
                this.letters.put(Character.toString(letra), this.letters.get(Character.toString(letra))+1);
            } else {
                this.letters.put(Character.toString(letra), 1);
            }
        }

        //System.out.println("Sub Task is Done!");
    }

}
