package Prep1Teste2;
import java.util.Scanner;
public class ED235{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        for(int i=0;i<N;i++){
            int n = input.nextInt();
            int C=n;
            int P=0;
            for(int p=0;p<n;p++){
                for(int j=0;j<C;j++){
                    System.out.print("#");
                }
                for(int j=0;j<P;j++){
                    System.out.print(".");
                }
                C--;
                P++;
                System.out.println();
            }
        }
    }
}