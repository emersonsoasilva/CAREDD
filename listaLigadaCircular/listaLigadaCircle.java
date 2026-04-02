public class listaLigadaCircle {

    private No inicio;

    public listaLigadaCircle() {
        this.inicio = null;
    }

    public void inserirInicio(int x) {
        No novo = new No(x);

        if(inicio == null) {
            inicio = novo;
            novo.prox = inicio;
        } else {
            No temp = inicio;

            while (temp.prox != inicio) {
                temp = temp.prox;

            }

            temp.prox = novo;
            novo.prox = inicio;
            inicio = novo;
        }
    }

    public void inserirFinal(int x) {
        No novo = new No(x);

        if(inicio == null) {
            inicio = novo;
            novo.prox = inicio;
        } else {
            No temp = inicio;

            while (temp.prox != inicio) {
                temp = temp.prox;

            }

            temp.prox = novo;
            novo.prox = inicio;
        }
    }

    public void exibirLista() {
        if (inicio == null) {
            System.out.println("Lista vazia...");
    
        }


        No temp = inicio;

        do {
            System.out.print(temp.valor + " >> ");
            temp = temp.prox;
        } while (temp != inicio);

        System.out.print("Volta ao inicio");

    }

    public void removerInicio() {
        if (inicio == null) {
            System.out.println("Lista vazia");
        }

        if (inicio.prox == inicio) {
            inicio = null;
        }

        No temp = inicio;

        while (temp.prox != inicio ) {
            temp = temp.prox;
        }

        inicio = inicio.prox;

        temp.prox = inicio;
    }

    public void removerFinal() {
        if (inicio == null) {
            System.out.println("Lista vazia");
        }

        if (inicio.prox == inicio) {
            inicio = null;
        }

        No temp = inicio;
        No anterior = null;

        while (temp.prox != inicio ) {
            anterior = temp;
            temp = temp.prox;
        }

        anterior.prox = inicio;
    }
}
