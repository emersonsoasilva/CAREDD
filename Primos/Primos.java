import java.util.Scanner;


public class Primos {

    static No inicio = null; // <- VARIÁVEL GLOBAL
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Informe o valor de N: ");
        int N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            inserir(i);
        }
        primos(N);
        
        exibir(inicio);
        System.out.println("Existem "+tamanho(inicio)+" numeros primos entre 0 e "+N);
    }
    
    private static void primos(int n){
        if (n > 1) {
            for (int i = 2; i * i <= n; i++) {
                if
            }
        }

        else {

        }
      
    }
    
    private static int tamanho(No temp){
       
        return 0;
    }    
    
    
    private static void inserir(int x) {
        No novo = new No(x);

        if (inicio == null) 
            inicio = novo;
        else 
            if (novo.valor <= inicio.valor) {
                novo.prox = inicio;
                inicio = novo;
            } else {
                No temp = inicio;
                
                while ((temp.prox != null) && (temp.prox.valor <= novo.valor)) 
                    temp = temp.prox;
                
                if (temp.prox == null)
                    temp.prox = novo;
                else {
                    novo.prox = temp.prox;
                    temp.prox = novo;
                }
        }

     
    }
        
    private static void exibir(No temp) {
       
    }
}
