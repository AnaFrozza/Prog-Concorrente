package Atividade07.Implementacao_CyclicBarrier;

public class EstouroBarreira implements Runnable {
    Stencil_Code stCode;

    public EstouroBarreira(Stencil_Code classe) {
        this.stCode = classe;
    }

    @Override
    public void run() {
        this.stCode.count_itera++;
    }
}
