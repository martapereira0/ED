import java.util.Scanner;
class ED183{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    int arr[] = new int[N];
    int max=input.nextInt();
    int min=max;
    float soma=max;
    for(int i=1;i<N;i++){
      arr[i]=input.nextInt();
      if(arr[i]>max){
        max=arr[i];}
      else if(arr[i]<min){
        min=arr[i];}
      soma+=arr[i];
    }
    float media=soma/N;
    int amplitude = max - min;
    System.out.printf("%.2f",media);
    System.out.println();
    System.out.println(amplitude);
  }
}
