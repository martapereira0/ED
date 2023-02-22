package Prep2Teste2;
// -----------------------------------------------------------
// Estruturas de Dados 2022/2023 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/
// -----------------------------------------------------------
// Arvore binaria "normal"
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

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


   //ED233- Arvores na Terra de Dados
   //a)
   public int internal(){
      return internal(root,0);
   }
   private int internal(BTNode<T> n,int count){
      if (n==null) return 0;
      if (n.getLeft()!= null || n.getRight()!=null) return 1 + internal(n.getLeft(),count) + internal(n.getRight(),count);
      return 0 + internal(n.getLeft(),count) + internal(n.getRight(),count);
   }
   //b)
   public void cut(int d){
      cut(d,root,0);
      return;
   }
   private void cut(int d,BTNode<T> n,int level){
      if (n==null)return;
      if (d<=0){
         setRoot(null);
         return;
      }
      else if (level+1==d){
         n.setLeft(null);
         n.setRight(null);
      }
      cut (d,n.getLeft(),level+1);
      cut (d,n.getRight(),level+1);
      return;
   }
   //c)
   public int[] maxLevel(){
      int k[]=new int[depth()+1];
      int v[]=new int[2];
      v[0]=maxLevel(root,0,v,k,0,1);
      v[1]=200;
      return v;
   }
   private int maxLevel(BTNode <T> n,int level,int v[],int k[],int max,int count){
      if(n==null || level==depth()+1) return max;
      k[level]+=1;
      if (k[level]>max) max=k[level];
      maxLevel(n.getLeft(),level+1,v,k,max,count);
      maxLevel(n.getRight(),level+1,v,k,max,count);
      return max;
   }

   //ED239 - metodos para arvores binarias

   public int count(){
      return count(root);
   }
   private int count(BTNode<T> n){
      if (n==null) return 0;
      if ((n.getLeft()!=null && n.getRight()==null) || (n.getLeft()==null && n.getRight()!=null)) return 1 + count(n.getLeft()) + count(n.getRight());
      return 0 + count(n.getLeft()) + count(n.getRight());
   }

   public int level(T v){
      return level(v,root,0,0);
   }
   private int level(T v,BTNode<T> n,int cur,int level){
      if (n==null) return -1;
      if (n.getValue().equals(v)){
         return cur;
      }
      int a = level (v,n.getLeft(),cur+1,level);
      int b = level (v,n.getRight(),cur+1,level);
      if (a!=-1 && b!=-1) {
         return Math.min(a, b);
      }
      else
         return Math.max(a,b);
   }
   public int nos(int x){
      return nos(root,x,0);
   }
   private int nos(BTNode <T> n,int x,int cur){
      if (n==null) return 0;
      if (cur==x) return 1 + nos(n.getLeft(),x,cur+1) + nos(n.getRight(),x,cur+1);
      return 0 + nos(n.getLeft(),x,cur+1) + nos(n.getRight(),x,cur+1);
   }
}
