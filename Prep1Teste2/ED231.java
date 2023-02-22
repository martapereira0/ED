package Prep1Teste2;
import java.util.Scanner;

public class ED231{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=input.nextInt();
        }
        int flag=input.nextInt();
        if(flag==1){
            int max=arr[1]-arr[0];
            int min = max;
            for(int i=2;i<N;i++) {
                if (arr[i] - arr[i - 1] > max) max = arr[i] - arr[i - 1];
                if (arr[i] - arr[i - 1] < min) min =  arr[i] - arr[i - 1];
            }
            System.out.println(min+" "+max);
        }
        else if (flag==2){
            int tamanhomax=0;
            int tamanho=0;
            int marcador=0;
            int periodo=0;
            for (int i=1;i<N;i++){
                if (((arr[i]-arr[i-1])/(float)arr[i-1])*100 <= 5.00){
                    tamanho++;
                    marcador=1;
                    if (tamanho>tamanhomax) tamanhomax=tamanho;
                    if (i==N-1) periodo++;
                }
                else{
                    tamanho=0;
                    if (marcador==1){
                        periodo++;
                        marcador=0;
                    }
                }
            }
            System.out.println(periodo+" "+tamanhomax);
        }
        else{
            int flag2=0;
            int arr2[]=new int[N];
            for(int i=0;i<N;i++){
                arr2[i]=arr[i]/100;
            }
            int max=arr2[0];
            for(int i=1;i<N;i++){
                if (arr2[i]>max) max=arr2[i];
            }
            int rows=max;
            for(int i=0;i<rows;i++){
                for(int j=0;j<N;j++){
                    if (arr2[j]==max){
                        System.out.print("#");
                        flag2=1;
                        arr2[j]--;
                    }
                    else{
                        System.out.print(".");
                    }
                }
                System.out.println();
                if (flag2==1){
                    max--;
                }
            }
        }
    }
}