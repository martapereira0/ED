// -----------------------------------------------------------
// Estruturas de Dados 2021/2022 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2122/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria de pesquisa
// Ultima alteracao: 02/05/2018
// -----------------------------------------------------------
package Prep1Teste2;

import java.util.Scanner;

class TestBSTree {
   public static void main(String[] args) {
      BSTree<Integer> t1 = new BSTree<>();
      BSTree<Integer> t2 = new BSTree<>();
      BSTree<String> t3 = new BSTree<>();
      int[] nodes = {5,3,10,1,4,7,42};
      int[] data = {14,4,18,3,9,16,20,7,15,17,5};
      String[] names = {"ana", "pedro", "duarte", "afonso", "carlos", "luis"};

      for(int i=0; i<nodes.length; i++)
         t1.insert(nodes[i]);

      for(int i=0; i<data.length; i++)
         t2.insert(data[i]);

      for(int i=0; i<names.length; i++)
         t3.insert(names[i]);

      System.out.print("t1 em ");
      t1.printPreOrder();
      System.out.println("t1.minValue() = " + t1.minValue());
      System.out.println("t1.maxValue() = " + t1.maxValue());
      System.out.print("t2 em ");
      t2.printPreOrder();
      System.out.println("t2.minValue() = " + t2.minValue());
      System.out.println("t2.maxValue() = " + t2.maxValue());
      System.out.print("t3 em ");
      t3.printPreOrder();
      System.out.println("t3.minValue() = " + t3.minValue());
      System.out.println("t3.maxValue() = " + t3.maxValue());
   }
}






