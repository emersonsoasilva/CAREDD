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

        System.out.println("Antes");
        exibir(inicio);

                System.out.println("Existem "+tamanho(inicio)+" numeros primos entre 0 e "+N);
        
        System.out.println(" Depois");
        primos(N);
        exibir(inicio);

        System.out.println("Existem "+tamanho(inicio)+" numeros primos entre 0 e "+N);
    }
    
    private static void primos(int n){

        No temp = inicio;
        No anterior = null;

        while(temp != null) {

            int valor = temp.valor;
            int divisores = 0;

            for (int i = 1; i <= valor; i++) {
                if (valor % i == 0) {
                    divisores++;
                }
            }

            if (divisores == 2) {
                if (anterior == null) {
                    inicio = temp.prox;
                    temp = inicio;
                } else {
                    anterior.prox = temp.prox;
                    temp = temp.prox;
                }
            } else {
                anterior = temp;
                temp = temp.prox;
            }

        }


      
    }
    
    private static int tamanho(No temp){
       if (temp == null) {
            return 0;
       }

       int valor = temp.valor;
       int divisores = 0;

       for (int i = 1; i <= valor; i++) {
            if (valor % i == 0) {
                divisores++;
            }
       }

       if (divisores == 2) {
            return 1 + tamanho(temp.prox);
       } else {
            return tamanho(temp.prox);
       }

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

        No tmp = temp;

        while(tmp != null) {
            System.out.println(tmp.valor);
            tmp = tmp.prox;
        }
        System.out.println("Vazio...");
    }
}
