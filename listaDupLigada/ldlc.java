package listaDupLigada;

public class ldlc {

    static No inicio = null;
    
    public static void main(String[] args) {

    }
    
    static void inserirInicio(int x){
        No novo = new No(x);

        if(inicio == null){
            inicio = novo;
            novo.prox = novo;
            novo.ant  = novo;
        }
        else {
            No ultimo = inicio.ant;

            novo.prox = inicio;
            novo.ant  = ultimo;

            ultimo.prox = novo;
            inicio.ant  = novo;

            inicio = novo;
        }
    }
    
    static void inserirFinal(int x){
        No novo = new No(x);

        if(inicio == null){
            inicio = novo;
            novo.prox = novo;
            novo.ant  = novo;
        }
        else {
            No ultimo = inicio.ant;

            novo.prox = inicio;
            novo.ant  = ultimo;

            ultimo.prox = novo;
            inicio.ant  = novo;
        }
    }
    
    static void inserirOrdenado(int x){
        No novo = new No(x);

        if(inicio == null){
            inicio = novo;
            novo.prox = novo;
            novo.ant  = novo;
        }

        else if(x < inicio.valor){
            inserirInicio(x);
        }

        else {
            No temp = inicio;

            // percorre até achar posição ou voltar ao início
            while(temp.prox != inicio && temp.prox.valor < x)
                temp = temp.prox;

            // inserção no meio ou fim
            novo.prox = temp.prox;
            novo.ant  = temp;

            temp.prox.ant = novo;
            temp.prox = novo;
        }
    }

    static void exibir(){
        if(inicio == null){
            System.out.println("Lista vazia!");
        }
        else {
            No temp = inicio;

            do {
                System.out.print(temp.valor + " ↔ ");
                temp = temp.prox;
            } while(temp != inicio);

            System.out.println("(início)");
        }
    }

    static void exibirInverso(){
        if(inicio == null){
            System.out.println("Lista vazia!");
        }
        else {
            No temp = inicio.ant; // começa do último

            do {
                System.out.print(temp.valor + " ↔ ");
                temp = temp.ant;
            } while(temp != inicio.ant);

            System.out.println("(fim)");
        }
    }

    static void remover(int x){
        if(inicio == null){
            System.out.println("Lista vazia!");
            return;
        }

        No temp = inicio;

        do {
            if(temp.valor == x){

                // caso único elemento
                if(temp.prox == inicio){
                    inicio = null;
                }

                else {
                    temp.ant.prox = temp.prox;
                    temp.prox.ant = temp.ant;

                    if(temp == inicio)
                        inicio = inicio.prox;
                }

                return;
            }

            temp = temp.prox;

        } while(temp != inicio);

        System.out.println("Valor não encontrado!");
    }

    static void removerPrimeiro(){
        if(inicio == null){
            System.out.println("Lista vazia!");
        }
        else if(inicio.prox == inicio){
            inicio = null;
        }
        else {
            No ultimo = inicio.ant;

            inicio = inicio.prox;

            ultimo.prox = inicio;
            inicio.ant  = ultimo;
        }
    }

    static void removerUltimo(){
        if(inicio == null){
            System.out.println("Lista vazia!");
        }
        else if(inicio.prox == inicio){
            inicio = null;
        }
        else {
            No ultimo = inicio.ant;
            No penultimo = ultimo.ant;

            penultimo.prox = inicio;
            inicio.ant     = penultimo;
        }
    }

}
