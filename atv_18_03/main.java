public class main {
    public static void main(String[] args) {
        // Pilha p1 = new Pilha();

        // p1.empilhar(12);
        // p1.empilhar(7);   
        // p1.empilhar(8);
        // p1.empilhar(14);
     
        
        // System.out.println(p1.topo());
        
        // if(!p1.vazia())
        //     p1.exibir();
        
        // p1.desempilhar();
        
        Fila f1 = new Fila();     
        f1.enfileirar(0);
        
        f1.enfileirar(4);
        
        f1.enfileirar(5);
        
        f1.desenfileirar();
        
        if(!f1.vazia())
            f1.exibir();
            
        
    }
    
}

