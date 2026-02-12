void main(){
    exibeRec(5);
}

//

void exibeRec(int n){
    if(n == 1) {
        System.out.println(n);
    }
    else {
        System.out.println(n);
        exibeRec(n-1);
    }
};

// void exibeRec(int n){
//     if(n == 1) {
//         System.out.println(n);
//     }
//     else {
//         exibeRec(n-1);
//         System.out.println(n);
//     }
// };