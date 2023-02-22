package Prep1Teste2;
import java.util.Scanner;

public class ED268{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int p=0;p<n;p++){
            int N = in.nextInt();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if (i==j || i>N/2 && j<N/2 && i+j==N-1){
                        System.out.print("#");
                    }
                    else{
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
        }
    }
}