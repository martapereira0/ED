package Prep1Teste2;
// -----------------------------------------------------------
// Estruturas de Dados 2022/2023 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/
// -----------------------------------------------------------
// Exemplo de flood fill
// Ultima alteracao: 21/04/2018
// -----------------------------------------------------------

import java.util.Scanner;

public class ED200 {
   static int rows;            // Numero de linhas
   static int cols;            // Numero de colunas   
   static char m[][];          // Matriz de celulas
   static boolean visited[][]; // Saber se uma dada posicao ja foi visitada

   // Tamanho da mancha que inclui posicao (y,x)
   static int t(int y, int x) {
      if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
      if (visited[y][x]) return 0;  // Caso base: celula ja visitada
      if (m[y][x] == '.') return 0; // Caso base: celula vazia
      int count = 1;        // celula nao vazia
      visited[y][x] = true; // marcar como visitada
      count += t(y-1, x);   //horizontal, posicao imediatamente anterior
      count += t(y+1, x);  //horizontal,posicao imediatamente a seguir
      count += t(y, x+1); // vertical, posicao imediatamente abaixo
      count += t(y, x-1); // vertical, posicao imediatamente acima
      count += t(y+1,x-1); //diagonal secundária, posicao imediatamente acima
      count += t(y-1,x-1); //diagonal principal, posicao imediatamente acima
      count += t(y-1,x+1); //diagonal secundária, posicao imediatamente abaixo
      count += t(y+1,x+1); //diagonal principal, posicao imediatamente abaixo
      return count;
   }





   // -----------------------------------------------------------
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      int N = in.nextInt();
      for(int p=0;p<N;p++){
         // Leitura de uma matriz de caracteres
         rows = in.nextInt();
         cols = in.nextInt();
         m = new char[rows][cols];
         visited = new boolean[rows][cols];
         int countmax=0;
         for (int i=0; i<rows; i++)
            m[i] = in.next().toCharArray();
         for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
               countmax=Math.max(t(j,i),countmax);
            }
         }
         System.out.println(countmax);
      }

   }
   
}
