package Prep1Teste2;
import java.util.*;

public class ED120 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int C=1;
        int P=N-1;
        for(int p=0;p<N;p++){
            for(int i=0;i<P/2;i++){
                System.out.print(".");
            }
            for(int i=0;i<C;i++){
                System.out.print("#");
            }
            for(int i=0;i<P/2;i++){
                System.out.print(".");
            }
            if (p<N/2){
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