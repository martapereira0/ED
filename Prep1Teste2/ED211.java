package Prep1Teste2;
public class ED211 {
    public static int countEven(BTree<Integer> t) {
        return countEven(t.getRoot());
    }

    private static int countEven(BTNode<Integer> n) {
        if (n == null) return 0;
        if (n.getValue() % 2 == 0)
            return 1 + countEven( n.getRight()) + countEven(n.getLeft());
        return 0 + countEven(n.getRight()) + countEven(n.getLeft());
    }
}