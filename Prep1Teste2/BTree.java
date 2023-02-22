package Prep1Teste2;
// -----------------------------------------------------------
// Estruturas de Dados 2022/2023 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/
// -----------------------------------------------------------
// Arvore binaria "normal"
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Arrays;
import java.util.Arrays;
public class BTree<T> {
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {return root;}
   public void setRoot(BTNode<T> r) {root = r;}

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore   
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
      if (n == null) return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null) return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------
   
   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n==null) return false;
      if (n.getValue().equals(value)) return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n==null) return;
      System.out.print(" " + n.getValue() );
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------
   
   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BTNode<T> n) {
      if (n==null) return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BTNode<T> n) {
      if (n==null) return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");
      
      MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------
   
   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");
      
      MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }

   //ED204-Contando folhas
   public int numberLeafs(){
      return numberLeafs(root);
   }
   private int numberLeafs(BTNode<T> n){
      if (n==null) return 0;
      if (n.getRight()==null && n.getLeft()==null) return 1;
      return numberLeafs(n.getRight()) + numberLeafs(n.getLeft());
   }
   //ED205-Árvores estritamente binárias
   public boolean strict(){
      return strict(root);
   }
   private boolean strict(BTNode<T>n){
      if (n==null) return true;
      if ((n.getLeft()==null && n.getRight()!=null) || (n.getLeft()!=null && n.getRight()==null))
         return false;
      return strict(n.getLeft()) && strict(n.getRight());
   }
   //ED207-Nós profundos
   public int nodesLevel(int k){
      return nodesLevel(k,root,0);
   }
   private int nodesLevel(int k,BTNode<T> n,int level){
      if (n==null) return 0;
      if (level==k) return 1;
      return nodesLevel(k,n.getRight(),level+1) + nodesLevel(k,n.getLeft(),level+1);
   }
   //ED206 -Percorrendo caminhos
   public T path(String s){
      return path(s,root,0);
   }
   private T path(String s, BTNode <T> n,int pos){
      if (pos==s.length()) return n.getValue();
      if (s.charAt(pos)=='R') return path(s,n,pos+1);
      if (s.charAt(pos)=='E') return path(s,n.getLeft(),pos+1);
      return path(s,n.getRight(),pos+1);
   }
   public static int countEven(BTree<Integer> t) {
      return countEven(t.getRoot());
   }

   private static int countEven(BTNode<Integer> n) {
      if (n == null) return 0;
      if (n.getValue() % 2 == 0)
         return 1 + countEven( n.getRight()) + countEven(n.getLeft());
      return 0 + countEven(n.getRight()) + countEven(n.getLeft());
   }
   //ED233-arvores na terra dos dados
   //a
   public int internal(){
      return internal(root);
   }
   private int internal(BTNode <T> n) {
      if (n == null) return 0;
      else if (n.getLeft() != null || n.getRight() != null)
         return 1 + internal(n.getLeft()) + internal(n.getRight());
      return 0 + internal(n.getLeft()) + internal(n.getRight());
   }
   //b
   public void cut(int d){
      cut(d,0,root);
      return;
   }
   private void cut(int d,int level,BTNode<T> n){
      if (n==null) return;
      if (d<=0) setRoot(null);
      if (level+1==d){
         n.setLeft(null);
         n.setRight(null);
      }
      cut(d,level+1,n.getLeft());
      cut(d,level+1,n.getRight());
   }
   //c
   public int[] maxLevel(){
      int v[] = new int [2];
      int k[] = new int [depth()+1];
      k = maxLevel(k,root,0);
      int max = k[0];
      int count=0;
      if (k.length>1){
         for (int i = 1;i<depth()+1;i++){
            if (k[i]>max){
               max = k[i];
            }
         }
         for (int i = 0;i<depth()+1;i++){
            if (k[i]==max){
               count++;
            }
         }
      }
      else{
         count=1;
      }

      v[0]=max;
      v[1]=count;
      return v;
   }

   private int[] maxLevel(int k[],BTNode<T> n,int level) {
      if (n==null) return k;
      if (n.getValue()!=null){
         k[level]+=1;
      }
      maxLevel(k,n.getLeft(),level+1);
      maxLevel(k,n.getRight(),level+1);
      return k;
   }

   //ED239 A
   public int count(){
      return count(root,0);
   }
   private int count(BTNode <T> n,int count){
      if (n==null) return 0;
      if (n.getRight()==null && n.getLeft()==null) return count;
      if ((n.getLeft()!=null && n.getRight()==null) || (n.getLeft()==null && n.getRight()!=null)) return 1+ count(n.getLeft(),count) + count(n.getRight(),count);
      return 0+ count(n.getLeft(),count) + count(n.getRight(),count);
   }

   //B
   public int level(T v){
      return level(v,root,0);
   }
   private int level(T v,BTNode <T> n,int level){
      if(n==null) return -1;
      if(n.getValue()==v) return level;
      int v1 = level(v,n.getLeft(),level+1);
      int v2 = level(v,n.getRight(),level+1);
      if (v1!=-1 && v2!=-1){
         return Math.min(v1,v2);
      } else return Math.max(v1,v2);
   }

   public int levels(){
      return levels(root);
   }
   private int levels(BTNode <T> n){
      if (n==null) return 0;
      return 1 + Math.max(levels(n.getLeft()),levels(n.getRight()));
   }
}
