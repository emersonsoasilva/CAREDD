public class Pilha {
    private No topo; // topo é o nó de controle da lista o "início" da implementação anterior
    
    public Pilha(){
        this.topo = null;
    }
    
    public void empilhar(int x){
        No nNo = new No(x);
        nNo.prox = topo;
        topo = nNo;
        

    }
    
    public void desempilhar(){
        if(!vazia()) {

            System.out.println("Removido apos desempilhar: " + topo.valor);
            topo = topo.prox;
        }
        
    }
    
    public int topo(){
        int val = 0;

        if(!vazia()) {
            val = topo.valor;
        }
    
        return val;
    }
    
    public boolean vazia(){

        return topo == null;
    }
    
    public int tamanho(){
        int incrementador = 0;
        No atual = topo;

        while (atual != null) {
            incrementador++;
            atual = atual.prox;
        }

        return incrementador;
    }
    
    public void exibir(){
        No atual = topo;

        while (atual !=  null) {
            System.out.print(atual.valor + " ==> ");

            atual = atual.prox;
        }

        System.out.println("null");
    }
    
}
