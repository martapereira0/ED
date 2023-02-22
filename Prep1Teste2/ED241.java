package Prep1Teste2;
import java.util.*;
public class ED241{
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);

        BSTree <String> arv = new BSTree<>();
        BSTMap <String,Integer> dicio = new BSTMap<>(); //problemas e quantidade de vezes que aquele problema foi submetido
        BSTMap <String,Integer> dicio1 = new BSTMap<>(); //problemas com a quantidade de vezes em que sao aceites


        int flag = in.nextInt();
        int N = in.nextInt();
        in.nextLine(); //consumir /n
        int max=0;
        String str="";


        for(int i=0;i<N;i++) {
            String nome = in.next();
            String problema = in.next();
            String estado = in.next();
            in.nextLine(); //consumir /n
            arv.insert(nome);
            if (dicio.get(problema) == null || dicio1.get(problema) == null) {
                dicio.put(problema, 1);
                if (estado.equals("Accepted")) {dicio1.put(problema, 1);}
                //System.out.println(problema+" "+dicio.get(problema));
                //System.out.println(problema+" "+dicio1.get(problema));
            } else if (dicio.get(problema) != null || dicio1.get(problema) != null) { //caso seja um problema repetido
                int count = dicio.get(problema);
                count++;
                if (count > max) {
                    max = count;
                    str = problema;
                }
                dicio.put(problema, count);
                //System.out.println(problema+" "+dicio.get(problema));
                if (estado.equals("Accepted")) {
                    int aceite = dicio1.get(problema);
                    aceite++;
                    dicio1.put(problema, aceite);
                }
                //System.out.println(problema+" "+dicio1.get(problema));
            }
        }



        if (flag==1) System.out.println(arv.numberNodes());
        if (flag==2) System.out.println(str+" "+max);
        else if (flag==3){
            LinkedList <String> exs = dicio.keys();
            for(int i=0;i<exs.size();i++){
                String k = exs.get(i);
                if ((float)dicio1.get(k)/(float)dicio.get(k)>=0.5){
                    System.out.println(k);
                }
            }
        }
        else if (flag==4){
            
        }
    }
}