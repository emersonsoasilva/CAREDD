package arvoreBinaria;

public class ex_01 {
   public static NoA raiz = null;
    
    
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            int x = (int) (Math.random()*100);
            //System.out.println("Inserindo: "+x);
            inserir(x);
        }
        System.out.println("------ exibicao --------");
        exibeArvore(raiz,0);
        
        System.out.println("Maior: " + maior(raiz));
        System.out.println("Menor: " + menor(raiz));
        System.out.print("Folhas: "); exibeFolhas(raiz);
        System.out.println("");
        System.out.println("Profundidade: " + profundidade(raiz));
        System.out.println("Tamanho: " + tamanho(raiz));
        
        
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
    
    public static void exibir(NoA temp){
        if(temp != null){
            //A alteração da ordem das linhas abaixo implica se a exibição da árvore será em pré-ordem, em-ordem ou pós-ordem.
            System.out.println(temp.valor);
            exibir(temp.esq);
            
            exibir(temp.dir);
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

    public static int maior(NoA temp) {
        if(temp != null){
            int x = maior(temp.dir);
            if(temp.valor > x)
                return temp.valor;
            else
                return x;
        }
        return -1;
    }
    
    public static int menor(NoA temp) {
        if(temp != null){
            int x = menor(temp.esq);
            if(temp.valor < x)
                return temp.valor;
            else
                return x;
        }
        return 50000;
    }

    public static void exibeFolhas(NoA temp){
        if(temp != null){
            exibeFolhas(temp.esq);
            if(ehFolha(temp))
                System.out.print(temp.valor+" ");
            exibeFolhas(temp.dir);
        }
    }

    private static boolean ehFolha(NoA temp) {
        if((temp.esq == null) && (temp.dir==null))
            return true;
        return false;
    }

    private static int profundidade(NoA temp) {
        if(temp != null){
            if(ehFolha(temp))
                return 0;
            else{
                int x = profundidade(temp.esq);
                int y = profundidade(temp.dir);
                int r = (x>y)? x : y;
                return r+1;
            }
        }
        return -1;
    }

    private static int tamanho(NoA temp) {
       if(temp != null)
           return 1+tamanho(temp.esq)+tamanho(temp.dir);

       return 0;
    }
}