package Prep2Teste2;
// -----------------------------------------------------------
// Estruturas de Dados 2022/2023 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.*;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);
      t.printPreOrder();
      System.out.println(t.nos(2));

      // Escrever nos da arvore seguindo varias ordens possiveis


   }
}
