void main() {
    int[] vet = {1, 2, 3, 40};
    System.out.println(sumVetor(4, vet));
}

int sumVetor(int t, int[] v) {
    if(t == 0) {
        return 0;
    }
    else {
        return v[t-1] + sumVetor(t-1, v);
    }
}
