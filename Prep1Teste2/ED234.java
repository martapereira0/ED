package Prep1Teste2;
import java.util.*;

public class ED234{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        BSTree <String> movies = new BSTree<>();
        BSTMap <String,Integer> dicio1 = new BSTMap<>(); //dicionario com os nomes e o numero de ocorrencias
        BSTMap <String,Integer> dicio2 = new BSTMap<>(); //dicionario com os noems e a soma das notas


        int flag = in.nextInt();
        int N = in.nextInt();
        int max = 0;
        String str="";
        for(int i=0;i<N;i++){
            String word = in.next();
            int nota = in.nextInt();
            movies.insert(word);
            if(dicio1.get(word)==null){
                dicio1.put(word,1);
                dicio2.put(word,nota);
            }
            else{
                int count = dicio1.get(word);
                count++;
                if  (count>max){
                    max=count;
                    str=word;
                }
                dicio1.put(word,count);
                int sum = dicio2.get(word) + nota;
                dicio2.put(word,sum);
            }
        }
        if (flag==1) System.out.println(movies.numberNodes());
        if (flag==2) System.out.println(str+" "+max);
        else if (flag==3) {
            LinkedList <String> lista1 = dicio1.keys();
            for(String i : lista1) {
                if (dicio2.get(i) / dicio1.get(i) >= 5) {
                    System.out.println(i);
                }
            }
            /* OU
            for(int i=0;i<dicio1.size();i++){
                String nome = lista1.get(i);
                if (dicio2.get(nome)/dicio1.get(nome) >= 5){
                    System.out.println(nome);
                }
            }*/
        }
    }
}