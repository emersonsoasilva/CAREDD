package arvoreBinaria;

public class avl {

    public static NoA raiz = null;

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            int x = (int) (Math.random() * 100);
            //System.out.println("Inserindo: " + x);
            inserir(x);
        }
        System.out.println("------ exibicao --------");
        exibeArvore(raiz, 0);
        System.out.println("------ Fator de Balanceamento --------");
        mostrarFB(raiz);
        if(ehAVL(raiz)){
            System.out.println("A árvore é AVL.");
        } else {
            System.out.println("A árvore não é AVL.");
        }
    }


    public static void mostrarFB(NoA raiz){
        if(raiz != null){
            mostrarFB(raiz.esq);
            System.out.println("Valor: "+raiz.valor+" FB: "+fatorBalanceamento(raiz));
            mostrarFB(raiz.dir);
        }
    }

    public static int fatorBalanceamento(NoA n){
        if(n != null){
            int x = altura(n.esq);
            int y = altura(n.dir);
            return x - y;
        }
        return 0;
    }

    public static boolean ehAVL(NoA n){
        if(n != null){
            int fb = fatorBalanceamento(n);
            if (fb < -1 || fb > 1) {
                return false;
            } else {
                return ehAVL(n.esq) && ehAVL(n.dir);
            }
        }
        return true;
    }

    public static int altura(NoA n) {
        if(n == null) {
            return -1;
         
        } else {
            int x = altura(n.esq);
            int y = altura(n.dir);
            if(x > y) {
                return x + 1;
            
            } else {
                return y + 1;
            }
        }
    }

    public static void inserir(int x) {
        NoA novo = new NoA(x);

        if (raiz == null) {
            raiz = novo;
        } else {

            NoA temp = raiz;
            boolean inseriu = false;

            while (!inseriu) {
                if (novo.valor <= temp.valor) {
                    if (temp.esq == null) {
                        temp.esq = novo;
                        inseriu = true;
                    } else {
                        temp = temp.esq;
                    }
                } else {
                    if (temp.dir == null) {
                        temp.dir = novo;
                        inseriu = true;
                    } else {
                        temp = temp.dir;
                    }
                }
            }
        }
    }

    public static void exibeArvore(NoA n, int x){

        if(n.dir != null)
            exibeArvore(n.dir, x+1);
        else
            System.out.println();

        for(int i=1; i<=x; i++)
            System.out.print("|  ");
        
        if((n.esq == null)&&(n.dir == null))
            System.out.print("["+n.valor+"]");
        else
            System.out.print(n.valor);
   
        if(n.esq != null)
            exibeArvore(n.esq, x+1);
        else
            System.out.println();
        
    }
}
