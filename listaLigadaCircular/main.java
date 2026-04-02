public class main {
    public static void main(String[] args) {
        listaLigadaCircle lsc1 = new listaLigadaCircle();

        // lsc1.inserirInicio(50);
        // lsc1.inserirInicio(5);
        // lsc1.inserirInicio(10);
        // lsc1.inserirInicio(0);
        // lsc1.inserirInicio(67);
        // lsc1.exibirLista();

        lsc1.inserirInicio(50);
        lsc1.inserirInicio(5);
        lsc1.inserirInicio(10);
        // lsc1.removerFinal();
        lsc1.removerInicio();

        lsc1.exibirLista();
    }
}
