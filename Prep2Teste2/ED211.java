package Prep2Teste2;
import java.util.Scanner;

public class ED211{
    public static int countEven(BTree<Integer> t){
        return countEven(t.getRoot(),0);
    }
    private static int countEven(BTNode <Integer> n,int count){
        if (n==null) return 0;
        if (n.getValue()%2==0) return 1 + countEven(n.getLeft(),count) + countEven(n.getRight(),count) ;
        return 0 + countEven(n.getLeft(),count) + countEven(n.getRight(),count) ;
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        BTree<Integer> t = LibBTree.readIntTree(in);
        System.out.println(countEven(t));
    }
}