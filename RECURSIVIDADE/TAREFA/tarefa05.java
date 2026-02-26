void main() {

}

int menorElemento(int t, int[] v) {
    if(t == 0) {
        return 0;
    }
    else {
        return v[t-1] + menorElemento(t-1, v);
    }
}
