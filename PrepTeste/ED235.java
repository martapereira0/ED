import java.util.Scanner;

class ED235{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    for(int i=0;i<N;i++){
      int dim = input.nextInt();
      int C=dim;
      int P=0;
      for(int j=0;j<dim;j++){
        for(int k=0;k<C;k++){
          System.out.print("#");
        }
        for(int k=0;k<P;k++){
          System.out.print(".");
        }
        C--;
        P++;
        System.out.println();
      }
    }
  }
}
