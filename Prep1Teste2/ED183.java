package Prep1Teste2;
import java.util.Scanner;
public class ED183{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int arr[]=new int[N];
        arr[0]=in.nextInt();
        int max=arr[0];
        int sum=max;
        int min=max;
        for(int i=1;i<N;i++){
            arr[i]=in.nextInt();
            sum+=arr[i];
            if (arr[i]>max) max=arr[i];
            if (arr[i]<min) min=arr[i];
        }
        float media = sum/(float) N;
        System.out.printf("%.2f",media);
        System.out.println();
        System.out.println(max-min);
    }
}