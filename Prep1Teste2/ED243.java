package Prep1Teste2;
import java.util.Scanner;
import java.util.Arrays;
public class ED243{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int ningngosta =  input.nextInt(); //nº de ing que nao gosta
        int ingngosta []= new  int[ningngosta];
        for(int i=0;i<ningngosta;i++){
            ingngosta[i]=input.nextInt(); //array c/ os ing que ele nao gosta
        }
        input.nextLine(); //consumir o /n
        int npizzas = input.nextInt();
        int count = npizzas;
        for(int i=0;i<npizzas;i++){
            int flag=0;
            int ning = input.nextInt(); //nº de ingredientes da pizza
            int pizza[]=new int[ning]; //array para armazenar os ingredientes de cada pizza
            for(int j=0;j<ning;j++){
                pizza[j]=input.nextInt();
            }
            for(int j=0;j<ningngosta;j++){ //percorrer o array c/ os ing que o mario nao gosta
                for(int y=0;y<ning;y++){ //percorrer o array com os ingredientes que a pizza tem
                    if(ingngosta[j]==pizza[y]){
                        flag=1;
                    }
                }
                if (flag==1){
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}