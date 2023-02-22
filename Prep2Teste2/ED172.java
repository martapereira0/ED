package Prep2Teste2;
import java.util.*;
public class ED172 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BSTMap <String,Integer> dicio = new BSTMap<>();

        while (in.hasNext()){
            String word = in.next();
            if (dicio.get(word)==null){
                dicio.put(word,1);
            }
            else{
                int count = dicio.get(word);
                count++;
                dicio.put(word,count);
            }
        }

        for(String i : dicio.keys()){
            System.out.println(i+": "+dicio.get(i));
        }
    }
}