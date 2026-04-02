
public class Fila {

    private No cabeca; // cabeca é o nó de controle da lista o "início" da implementação anterior

    public Fila() {
        this.cabeca = null;
    }

    public void enfileirar(int x) {
        No nNo = new No(x);

        if (vazia()) {
            cabeca = nNo;
        } else {
            No atual = cabeca;

            while (atual.prox != null) {
                atual = atual.prox;
            }

            atual.prox = nNo;
        }
    }

    public void desenfileirar() {
        if (!vazia()) {
            System.out.println("Removido apos desenfileirar: " + cabeca.valor);
            cabeca = cabeca.prox;

        }
    }

    public int cabeca() {
        int val = 0;

        if (!vazia()) {
            val = cabeca.valor;
        }

        return val;
    }

    public int cauda() {
        int val = 0;

        if (!vazia()) {
            No atual = cabeca;

            while (atual.prox != null) {
                atual = atual.prox;
            }

            val = atual.valor;
        }

        return val;
    }

    public boolean vazia() {

        return cabeca == null;
    }

    public int tamanho() {
        int incrementador = 0;
        No atual = cabeca;

        while (atual != null) {
            incrementador++;
            atual = atual.prox;
        }

        return incrementador;
    }

    public void exibir() {
        No atual = cabeca;

        while (atual != null) {
            System.out.print(atual.valor + " ==> ");

            atual = atual.prox;
        }

        System.out.println("null");

    }

}
