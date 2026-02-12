void main(){

    System.out.println(soma(8));
}

int soma(int i){

    if(i == 1){
        return i;
    }

    else {
        return i + soma(i-1);
    }
}