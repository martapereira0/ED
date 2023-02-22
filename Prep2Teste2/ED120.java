package Prep2Teste2;
import java.util.Scanner;

public class ED120{
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int C = 1;
        int P = n-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<P/2;j++){
                System.out.print(".");
            }
            for(int j=0;j<C;j++){
                System.out.print("#");
            }
            for(int j=0;j<P/2;j++){
                System.out.print(".");
            }
            if (i<n/2){
                C+=2;
                P-=2;
            }
            else{
                C-=2;
                P+=2;
            }
            System.out.println();
        }
    }
}