package listaDupLigada;

public class listasDuplamenteLigadas {

    static No inicio = null;
    
    public static void main(String[] args) {

    }
    
    // Inserir no início
    static void inserirInicio(int x){
        No novo = new No(x);

        if(inicio == null)
            inicio = novo;
        else {
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        }
    }
    
    // Inserir no final
    static void inserirFinal(int x){
        No novo = new No(x);

        if(inicio == null)
            inicio = novo;
        else {
            No temp = inicio;

            while(temp.prox != null)
                temp = temp.prox;

            temp.prox = novo;
            novo.ant = temp;
        }
    }
    
    // Inserir ordenado (crescente)
    static void inserirOrdenado(int x){
        No novo = new No(x);

        if(inicio == null)
            inicio = novo;

        else if(x < inicio.valor){
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        }

        else {
            No temp = inicio;

            while(temp.prox != null && temp.prox.valor < x)
                temp = temp.prox;

            novo.prox = temp.prox;

            if(temp.prox != null)
                temp.prox.ant = novo;

            temp.prox = novo;
            novo.ant = temp;
        }
    }

    // Exibir normal
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

    // Exibir inverso
    static void exibirInverso(){
        if(inicio == null)
            System.out.println("Lista vazia!");
        else {
            No temp = inicio;

            // vai até o último
            while(temp.prox != null)
                temp = temp.prox;

            // volta imprimindo
            while(temp != null){
                System.out.print(temp.valor + " ↔ ");
                temp = temp.ant;
            }
            System.out.println("null");
        }
    }

    // Remover valor específico
    static void remover(int x){
        if(inicio == null){
            System.out.println("Lista vazia!");
            return;
        }

        No temp = inicio;

        // procura o valor
        while(temp != null && temp.valor != x)
            temp = temp.prox;

        if(temp == null){
            System.out.println("Valor não encontrado!");
        }

        else if(temp == inicio){
            removerPrimeiro();
        }

        else if(temp.prox == null){
            removerUltimo();
        }

        else {
            temp.ant.prox = temp.prox;
            temp.prox.ant = temp.ant;
        }
    }

    // Remover primeiro
    static void removerPrimeiro(){
        if(inicio == null)
            System.out.println("Lista vazia!");
        else if(inicio.prox == null)
            inicio = null;
        else {
            inicio = inicio.prox;
            inicio.ant = null;
        }
    }

    // Remover último
    static void removerUltimo(){
        if(inicio == null)
            System.out.println("Lista vazia!");
        else if(inicio.prox == null)
            inicio = null;
        else {
            No temp = inicio;

            while(temp.prox != null)
                temp = temp.prox;

            temp.ant.prox = null;
        }
    }

}
