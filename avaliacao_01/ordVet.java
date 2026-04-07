package avaliacao_01;

import java.util.Scanner;

public class ordVet {

    public static void main(String[] args) {

        int[] tamanhos = {5000, 10000, 30000, 50000};
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Escolha o algoritmo de ordenacao ===");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Selection Sort");
        System.out.println("3 - Insertion Sort");
        System.out.println("4 - Merge Sort");
        System.out.println("5 - Heap Sort");
        System.out.println("6 - Counting Sort");
        System.out.println("7 - Quick Sort");
        System.out.print("Sua escolha: ");
        int escolha = scanner.nextInt();
        scanner.close();

        String nomeAlgoritmo = "";
        switch (escolha) {
            case 1: nomeAlgoritmo = "Bubble Sort";           break;
            case 2: nomeAlgoritmo = "Selection Sort";        break;
            case 3: nomeAlgoritmo = "Insertion Sort";        break;
            case 4: nomeAlgoritmo = "Merge Sort";            break;
            case 5: nomeAlgoritmo = "Heap Sort";             break;
            case 6: nomeAlgoritmo = "Counting Sort";         break;
            case 7: nomeAlgoritmo = "Quick Sort";            break;
            default:
                System.out.println("Opcao invalida!");
                return;
        }

        for (int t = 0; t < tamanhos.length; t++) {

            int N = tamanhos[t];

            System.out.println("\n--- " + nomeAlgoritmo + " | N=" + N + " ---");

            int[] vetAleatorio = new int[N];
            int[] vetMelhor    = new int[N];
            int[] vetPior      = new int[N];

            inicializarVetor(vetAleatorio, N, 0);
            inicializarVetor(vetMelhor,    N, 1);
            inicializarVetor(vetPior,      N, 2);

            String[] nomes    = {"Aleatorio", "Melhor Caso", "Pior Caso"};
            int[][] originais = {vetAleatorio, vetMelhor, vetPior};

            for (int c = 0; c < 3; c++) {

                int[] vet = new int[N];
                for (int i = 0; i < N; i++)
                    vet[i] = originais[c][i];

                long inicio = System.currentTimeMillis();

                switch (escolha) {
                    case 1: ordenarBubble(vet, N);          break;
                    case 2: ordenarSelection(vet, N);       break;
                    case 3: ordenarInsertion(vet, N);       break;
                    case 4: ordenarMerge(vet, 0, N - 1);    break;
                    case 5: ordenarHeap(vet, N);            break;
                    case 6: ordenarCounting(vet, N);        break;
                    case 7: ordenarQuick(vet, 0, N - 1);    break;
                }

                long fim     = System.currentTimeMillis();
                long tempo   = fim - inicio;
                long tempoS  = tempo / 1000;
                long tempoMS = tempo - tempoS * 1000;

                System.out.println("Tempo " + nomes[c] + ": " + tempoS + "s " + tempoMS + "ms");
            }
        }
    }

    // ======= INICIAR VETOR

    static void inicializarVetor(int[] vet, int N, int s) {
        switch (s) {
            case 0:
                for (int i = 0; i < N; i++)
                    vet[i] = (int)(Math.random() * N * 2);
                break;
            case 1:
                for (int i = 0; i < N; i++)
                    vet[i] = i + 1;
                break;
            case 2:
                for (int i = 0; i < N; i++)
                    vet[i] = N - i;
                break;
        }
    }

    // ======= UTIL

    private static void troca(int[] vet, int a, int b) {
        int aux = vet[a];
        vet[a]  = vet[b];
        vet[b]  = aux;
    }

    // ======= 1 - BUBBLE SORT

    private static void ordenarBubble(int[] vet, int N) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N - 1; j++)
                if (vet[j] > vet[j + 1])
                    troca(vet, j, j + 1);
    }

    // ======= 2 - SELECTION SORT

    private static void ordenarSelection(int[] vet, int N) {
        for (int i = 0; i < N - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < N; j++)
                if (vet[j] < vet[minIdx])
                    minIdx = j;
            troca(vet, i, minIdx);
        }
    }

    // ======= 3 - INSERTION SORT

    private static void ordenarInsertion(int[] vet, int N) {
        for (int i = 1; i < N; i++) {
            int chave = vet[i];
            int j = i - 1;
            while (j >= 0 && vet[j] > chave) {
                vet[j + 1] = vet[j];
                j--;
            }
            vet[j + 1] = chave;
        }
    }

    // ======= 4 - MERGE SORT

    private static void ordenarMerge(int[] vet, int esq, int dir) {
        if (esq >= dir) return;
        int meio = (esq + dir) / 2;
        ordenarMerge(vet, esq, meio);
        ordenarMerge(vet, meio + 1, dir);
        merge(vet, esq, meio, dir);
    }

    private static void merge(int[] vet, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = vet[esq + i];
        for (int i = 0; i < n2; i++)
            R[i] = vet[meio + 1 + i];

        int i = 0, j = 0, k = esq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                vet[k] = L[i];
                i++;
            } else {
                vet[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) { vet[k] = L[i]; i++; k++; }
        while (j < n2) { vet[k] = R[j]; j++; k++; }
    }

    // ======= 7 - HEAP SORT

    private static void ordenarHeap(int[] vet, int N) {
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(vet, N, i);
        for (int i = N - 1; i > 0; i--) {
            troca(vet, 0, i);
            heapify(vet, i, 0);
        }
    }

    private static void heapify(int[] vet, int N, int i) {
        int maior = i;
        int esq   = 2 * i + 1;
        int dir   = 2 * i + 2;

        if (esq < N && vet[esq] > vet[maior]) maior = esq;
        if (dir < N && vet[dir] > vet[maior]) maior = dir;

        if (maior != i) {
            troca(vet, i, maior);
            heapify(vet, N, maior);
        }
    }

    // ======= 7 - COUNTING SORT 

    private static void ordenarCounting(int[] vet, int N) {
        int max = vet[0];
        for (int i = 1; i < N; i++)
            if (vet[i] > max)
                max = vet[i];

        int[] contagem = new int[max + 1];
        for (int i = 0; i < N; i++)
            contagem[vet[i]]++;

        for (int i = 1; i <= max; i++)
            contagem[i] += contagem[i - 1];

        int[] saida = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            saida[contagem[vet[i]] - 1] = vet[i];
            contagem[vet[i]]--;
        }

        for (int i = 0; i < N; i++)
            vet[i] = saida[i];
    }

    // ======= 7 - QUICK SORT

    private static void ordenarQuick(int[] vet, int baixo, int alto) {
        if (baixo < alto) {
            int pi = particionar(vet, baixo, alto);
            ordenarQuick(vet, baixo, pi - 1);
            ordenarQuick(vet, pi + 1, alto);
        }
    }

    private static int particionar(int[] vet, int baixo, int alto) {
        int meio = (baixo + alto) / 2;

        troca(vet, meio, alto);

        int pivo = vet[alto];
        int i    = baixo - 1;
        for (int j = baixo; j < alto; j++) {
            if (vet[j] <= pivo) {
                i++;
                troca(vet, i, j);
            }
        }
        troca(vet, i + 1, alto);
        return i + 1;
    }
}