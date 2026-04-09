void main() {
     int[] vet = {1, 2, 3, 40, 52, 0, 2};
    System.out.println(menorElemento(vet, 6));
}

int menorElemento(int v[] , int t) {
    if(t > 0) {
        int temp = menorElemento(v, t-1);

        if(temp < v[t]) {
            return temp;
        }

        return v[t];
    }

    return v[t];
}
