package Prep1Teste2;
import java.util.Scanner;
public class ED213{
    static int maxsum;
    static String strmax;

    public static String maxSum(BTree<Integer> t){
        maxsum=0;
        String str;
        maxSum(t.getRoot(),0,"");
        return strmax;
    }
    private static void maxSum(BTNode<Integer> n, int sum,String str){
        if (n==null) return;
        //caso nao aconteca o caso base vai acontecer isto
        sum += n.getValue();
        if (n.getLeft()==null && n.getRight()==null){
            if (sum>maxsum){
                maxsum=sum;
                strmax=str;
            }
        }
        else{
            maxSum(n.getLeft(),sum,str+"E");
            maxSum(n.getRight(),sum,str+"D");

        }

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        BTree<Integer> t = LibBTree.readIntTree(in);
        System.out.println(maxSum(t));
    }
}