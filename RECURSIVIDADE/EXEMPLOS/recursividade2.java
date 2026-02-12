void main(){
    exibeRec(1, 6);
}

void exibeRec(int i, int n){
    if (i == n){
        System.out.println(i);
    }
    else {
        exibeRec(i+1, n);
        System.out.println(i);
    }
};