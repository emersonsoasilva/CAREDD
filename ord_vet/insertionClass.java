package ord_vet;

public class insertionClass {
        static void insertion(int[] vet, int N){
        
        for (int i = 1; i < N; ++i) {
            int key = vet[i];
            int j = i - 1;

            while (j >= 0 && vet[j] > key) {
                vet[j + 1] = vet[j];
                j = j - 1;
            }
            vet[j + 1] = key;
        }
    }

}
