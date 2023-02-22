package Prep2Teste2;
import java.util.*;

public class ED241{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int flag = in.nextInt();
        int N = in.nextInt();

        BSTree<String> arv = new BSTree<>();
        BSTMap<String,Integer> dicio = new BSTMap<>();
        BSTMap<String,Integer> dicio1 = new BSTMap<>();
        BSTMap<String,BSTree <String> > dicio2 = new BSTMap<>(); //dicionario com os nomes e lista ligada com os exs aceites



        int max= 0;
        String str="";

        for(int i=0;i<N;i++) {
            String nome = in.next();
            String problema = in.next();
            String resultado = in.next();

            arv.insert(nome);

             //flag=2
            if (dicio.get(problema) == null)
                dicio.put(problema, 1);
            else {
                int quanti = dicio.get(problema);
                quanti++;
                if (quanti > max) {
                    max = quanti;
                    str = problema;
                }
                dicio.put(problema, quanti);
            }

            //flag=3
            if(dicio1.get(problema)==null) {
                if (resultado.equals("Accepted")){
                    dicio1.put(problema, 1);
                }
            }
            else {
                if (resultado.equals("Accepted")){
                    int count = dicio1.get(problema);
                    count++;
                    dicio1.put(problema, count);
                }
            }

            //flag=4
            if(dicio2.get(nome)==null && resultado.equals("Accepted")){
                BSTree<String> t = new BSTree<>(); //lista ligada que contem ps exs de cada pessoa
                t.insert(problema);
                dicio2.put(nome,t);
            }
            else {
                if (resultado.equals("Accepted")){
                    //dicio2.get(nome) equivale a ir buscar a linkedlist t
                    dicio2.get(nome).insert(problema);
                    dicio2.put(nome,dicio2.get(nome));
                }
            }
        }

        if (flag==1) System.out.println(arv.numberNodes());
        if (flag==2) System.out.println(str+" "+max);
        else if(flag==3){
            LinkedList<String> chaves = dicio.keys();
            for(String p:chaves){
                if((float)dicio1.get(p)/(float)dicio.get(p)>=0.5)
                    System.out.println(p);
            }
        }
        else if (flag==4){
            for(String name : dicio2.keys()){
                if (dicio2.get(name).numberNodes()==dicio.size()){
                    System.out.println(name);
                }
            }
        }
    }
}