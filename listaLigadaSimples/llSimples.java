package listaLigadaSimples;

public class llSimples {
    static No inicio = null;
    
    public static void main(String[] args) {

        llSimples lista1 = new llSimples();
        llSimples lista2 = new llSimples();
        
        for (int i = 0; i < 10; i++) {

            int x = (int) (Math.random()*30);
            System.out.println("Inserindo: "+x);

            // lista1.inserir(x);
            lista1.inserirOrdenado(x);

        }
        System.out.println("Antes: ");
        lista1.exibir();
        
        System.out.println("Depois: ");
        lista1.removerUltimo();
        lista1.exibir();
        // lista2.exibir();
        // lista2.removerUltimo();
    }
    
    public void inserir(int x){
        No novo = new No(x);
        
        if(inicio == null)
            inicio = novo;
        else{
            No temp = inicio;
            while(temp.prox != null) //navegação até o final da lista
                temp = temp.prox;
            //aqui temp está no último nó da lista
            temp.prox = novo;
        }
    }

    public void inserirOrdenado(int x){
        No novo = new No(x); 

        //Caso 01 - esteja vazia:

        if (inicio == null || x < inicio.valor) {
            novo.prox = inicio;
            inicio = novo;
        } else {
            //Caso 02 - encontra a posição e percorre:
            No temp = inicio; 

            while (temp.prox != null && temp.prox.valor < x) {
                temp = temp.prox;
            }
            //Inserir de forma ordenada:
            novo.prox = temp.prox;
            temp.prox = novo;

        }
    }

    public void removerUltimo(){
        if (inicio == null) {

        }

        if(inicio.prox == null) {
            inicio = null;
        }

        No temp = inicio;

        while(temp.prox.prox != null) {
            temp = temp.prox;

        }
        
        temp.prox = null;
    }
    
    
    public void exibir(){
        if(inicio == null)
            System.out.println("Lista Vazia, nada a exibir.");
        else{
            System.out.println("--- Lista ----");
            No temp = inicio;
            while(temp != null){
                System.out.println(temp.valor);
                temp = temp.prox;
            }
        }
    }
}
