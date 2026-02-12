void main(){
    exibeRec(1, 6);
}

void exibeRec(int i, int n){
    if (i == n){
        System.out.println(i);
    }
    else {
        System.out.println(i);
        exibeRec(i+1, n);
    }
};