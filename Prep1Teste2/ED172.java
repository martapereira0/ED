package Prep1Teste2;
import java.util.*;
public class ED172{
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        BSTMap <String,Integer> dicio = new BSTMap<>();

        while (input.hasNext()){
            String word = input.next();
            if(dicio.get(word)!=null){
                int value = dicio.get(word);
                value++;
                dicio.put(word,value);
            }
            else{
                dicio.put(word,1);
            }
        }
        LinkedList<String> lchaves = dicio.keys();
        /*for(int i=0;i<lchaves.size();i++){
            System.out.println(lchaves.get(i)+": "+dicio.get(lchaves.get(i)));
        }*/
        for(String i : lchaves){
            System.out.println(i+": "+dicio.get(i));
        }
    }
}