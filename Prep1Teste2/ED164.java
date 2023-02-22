package Prep1Teste2;
import java.util.Scanner;
public class ED164{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.nextLine();//consumir o /n
        BSTree<String> dicio = new BSTree <>();
        for(int i=0;i<N;i++){
            dicio.insert(input.next());
        }
        System.out.println(dicio.numberNodes());
    }
}