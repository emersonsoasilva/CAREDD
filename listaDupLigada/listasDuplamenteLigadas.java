package listaDupLigada;

public class listasDuplamenteLigadas {

    static No inicio = null;
    static No fim = null;
    
    public static void main(String[] args) {

    }
    
    static void inserirInicio(int x){
        No novo = new No(x);

        if(inicio == null){
            inicio = fim = novo;
        }
        else {
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        }
    }
    
    static void inserirFinal(int x){
        No novo = new No(x);

        if(inicio == null){
            inicio = fim = novo;
        }
        else {
            fim.prox = novo;
            novo.ant = fim;
            fim = novo;
        }
    }
    
    static void inserirOrdenado(int x){
        No novo = new No(x);

        if(inicio == null){
            inicio = fim = novo;
        }

        else if(x < inicio.valor){
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        }

        else if(x > fim.valor){
            fim.prox = novo;
            novo.ant = fim;
            fim = novo;
        }

        else {
            No temp = inicio;

            while(temp.prox.valor < x)
                temp = temp.prox;

            novo.prox = temp.prox;
            temp.prox.ant = novo;

            temp.prox = novo;
            novo.ant = temp;
        }
    }

    static void exibir(){
        if(inicio == null)
            System.out.println("Lista vazia!");
        else {
            No temp = inicio;

            while(temp != null){
                System.out.print(temp.valor + " ↔ ");
                temp = temp.prox;
            }
            System.out.println("null");
        }
    }

    static void exibirInverso(){
        if(fim == null)
            System.out.println("Lista vazia!");
        else {
            No temp = fim;

            while(temp != null){
                System.out.print(temp.valor + " ↔ ");
                temp = temp.ant;
            }
            System.out.println("null");
        }
    }

    static void remover(int x){
        if(inicio == null){
            System.out.println("Lista vazia!");
            return;
        }

        No temp = inicio;

        while(temp != null && temp.valor != x)
            temp = temp.prox;

        if(temp == null){
            System.out.println("Valor não encontrado!");
        }

        else if(temp == inicio){
            removerPrimeiro();
        }

        else if(temp == fim){
            removerUltimo();
        }

        else {
            temp.ant.prox = temp.prox;
            temp.prox.ant = temp.ant;
        }
    }

    static void removerPrimeiro(){
        if(inicio == null)
            System.out.println("Lista vazia!");
        else if(inicio == fim){
            inicio = fim = null;
        }
        else {
            inicio = inicio.prox;
            inicio.ant = null;
        }
    }

    static void removerUltimo(){
        if(fim == null)
            System.out.println("Lista vazia!");
        else if(inicio == fim){
            inicio = fim = null;
        }
        else {
            fim = fim.ant;
            fim.prox = null;
        }
    }

}
