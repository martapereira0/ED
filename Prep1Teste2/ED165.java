package Prep1Teste2;
import java.util.Scanner;
public class ED165{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=input.nextInt();
        }

        BSTree<Integer> dicio = new BSTree<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dicio.insert(arr[i]+arr[j]);
            }
        }
        int P = input.nextInt();
        for(int i=0;i<P;i++){
            int value = input.nextInt();
            if(dicio.contains(value)){
                System.out.println(value+": "+"sim");
            }else{
                System.out.println(value+": "+"nao");
            }
        }
    }
}