import java.util.Arrays;
// -----------------------------------------------------------
// Estruturas de Dados 2022/2023 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }

   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first);
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null);
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }

   // Converte a lista para uma String
   public String toString() {
      String str = "{";
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";
      }
      str += "}";
      return str;
      }
   public T get(int pos) {

      if (pos < 0 || pos >= size)
         return null;

      if (pos == 0)
         return getFirst();
      else if (pos == size-1)
         return getLast();
      else {
         Node<T> cur = first;

         for (int i = 1; i <= pos; i++) {
            cur = cur.getNext();
         }

         return cur.getValue();
      }
   }

   public void duplicate(){
      if(size == 0) return;
      Node <T> cur = first;
      for(int i=0;i<size();i++){
         Node<T> dup = new Node<T>(cur.getValue(),cur.getNext());
         cur.setNext(dup);
         cur = cur.getNext().getNext();
         size++;
      }
   }
   public SinglyLinkedList<T> cut(int a, int k) {
      SinglyLinkedList<T> nlist = new SinglyLinkedList<>();
      Node<T> cur = first;

      for (int i = 0; i < size; i++) {
         if (i >= a && i <= k+a-1)
            nlist.addLast(cur.getValue());
         cur = cur.getNext();
      }


      return nlist;
   }

   public void shift(int k){
      if (k == size)
         return;

      for(int i=0;i<k;i++) {
         addLast(getFirst());
         removeFirst();
      }
   }
   public int[] occurrences(T elem){
      Node <T> cur = first;
      int arr[] = new int [size];
      int j=0;
      for(int i=0;i<size;i++){
         if(cur.getValue().equals(elem)){
            arr[j]=i;
            j++;
         }
         cur=cur.getNext();
      }
      if(j==0)
         return null;
      else
         return Arrays.copyOf(arr, j);
   }
   public T remove(int pos){
      Node<T> cur = first;
      if(pos>=size || pos < 0) return null;
      if(pos == 0){
         first = first.getNext();
         size--;
         return cur.getValue();
      }
      for(int i = 0; i<pos-1; i++){
         cur = cur.getNext();
      }
      Node<T> elim = cur.getNext(); //Guardar o nÃ³ a eliminar
      cur.setNext(cur.getNext().getNext());
      size--;
      return elim.getValue();
   }


   public SinglyLinkedList<T> reverse(){
      SinglyLinkedList<T> newlist = new SinglyLinkedList<T>();
      Node <T> cur = first;
      while(cur!=null){
         newlist.addFirst(cur.getValue());
         cur=cur.getNext();
      }
      return newlist;
   }

   public int[] occurences (T elem){
      int pos[] = new int[size];
      int index=0;
      Node <T> cur = first;
      for(int i=0;i<size;i++){
         if(cur.getValue().equals(elem)){
            pos[index]=i;
            index++;
         }
      }
      if(index==0){
         return null;
      }
      else{
         return Arrays.copyOf(pos,index);
      }
   }
   public void removeAll(T value){
      Node<T> cur = first;
      while(cur!=null && cur.getValue().equals(value)){
         removeFirst();
         cur = first;
      }
      while(cur!=null){
         if(cur.getNext().getValue().equals(value)) {
            cur.setNext(cur.getNext().getNext());
            size--;
         }
         else cur = cur.getNext();
      }
      if(cur.getValue().equals(value)) {
         removeLast();
      }
   }
   public void remove(SinglyLinkedList<T> toRemove){
     Node <T> cur = toRemove.first;
     for(int i=0;i<toRemove.size();i++){
         removeAll(cur.getValue());
         cur=cur.getNext();
     }
   }
}
