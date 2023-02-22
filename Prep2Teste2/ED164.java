package Prep2Teste2;
import java.util.*;
 public class ED164{
     public static void main(String[] args){
         Scanner in= new Scanner(System.in);
         int N = in.nextInt();
         in.nextLine();//consumir o /n

         BSTree<String> t = new BSTree<>();
         for(int i=0;i<N;i++){
             String word=in.next();
             t.insert(word);
         }
         System.out.println(t.numberNodes());
     }
 }