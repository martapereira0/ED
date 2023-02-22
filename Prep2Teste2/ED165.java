package Prep2Teste2;
import java.util.*;

public class ED165{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int arr[] = new int[N];

        BSTree<Integer> arv = new BSTree<>(); //nao guarda valores repetidos
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                arv.insert(arr[i]+arr[j]);
            }
        }
        int P = in.nextInt();
        for (int i = 0; i < P; i++) {
            int valor = in.nextInt();
            if (arv.contains(valor)){
                System.out.println(valor+": sim");
            }
            else{
                System.out.println(valor+": nao");
            }
        }
    }
}