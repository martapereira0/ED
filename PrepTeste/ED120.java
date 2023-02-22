import java.util.Scanner;
class ED120{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int C=1;
    int P=n-C;
    for(int i=0;i<n;i++){
        for(int y=0;y<P/2;y++){
          System.out.print(".");
        }
        for(int y=0;y<C;y++){
          System.out.print("#");
        }
        for(int y=0;y<P/2;y++){
          System.out.print(".");
        }
        System.out.println();
        if(i<n/2){
          P=P-2;
          C=C+2;
        }
        else{
          P=P+2;
          C=C-2;
        }
      }
    }
}
