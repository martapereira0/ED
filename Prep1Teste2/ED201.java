package Prep1Teste2;
// -----------------------------------------------------------
// Estruturas de Dados 2022/2023 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/
// -----------------------------------------------------------
// Geracao de subconjuntos
// Ultima alteracao: 21/04/2018
// -----------------------------------------------------------

import java.util.Scanner;

public class ED201 {
   public static int tempoviagem;
   public static int melhorplaylist=0;
   
   // Escrever todos os subconjuntos do array v[]
   static void sets(int v[]) {
      // array de booleanos para representar o conjunto
      boolean used[] = new boolean[v.length];
      goSets(0, v, used); // chamar funcao recursiva
   }

   // Gera todos os subconjuntos a partir da posicao 'cur'
   static void goSets(int cur, int v[], boolean used[]) {
      int playlist = 0;
      if (cur == v.length) {  // Caso base: terminamos o conjunto
         for (int i=0; i<v.length; i++) 
            if (used[i]){
               playlist+=v[i];
            }
         if (playlist>melhorplaylist && playlist<=tempoviagem){
            melhorplaylist=playlist;
         }
      } else {                  // Se nao terminamos, continuar a gerar
         used[cur] = true;      // Subconjuntos que incluem o elemento actual
         goSets(cur+1, v, used);// Chamada recursiva
         used[cur] = false;     // Subconjuntos que nao incluem o el. actual
         goSets(cur+1, v, used);// Chamada recursiva
      }
   }

   // -----------------------------------------------------------
   
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      tempoviagem = input.nextInt();
      int nmusics = input.nextInt();
      System.out.println(tempoviagem +" "+nmusics);
      input.nextLine();//consumir o /n
      int v[]=new int[nmusics];
      for(int i=0;i<nmusics;i++){
         v[i]=input.nextInt();
      }
      sets(v);
      System.out.println(melhorplaylist);
   }
}
