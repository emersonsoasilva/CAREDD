void main(){
    System.out.println(fat(4));
}

int fat(int x) {
    if(x == 1) {
        return x;

    }

    else {
        return x*(fat(x-1));
    }
}