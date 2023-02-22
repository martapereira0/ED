/*package Prep2Teste2;
import java.util.Scanner;
public class ED241{
    public static void main(String[] Args){
        Scanner in = new Scanner(System.in);
        int F = in.nextInt();
        int N = in.nextInt();
        int max = 0;
        String exercicio = " ";
        int ind = 0;
        BSTree<String> f1 = new BSTree<>();
        BSTMap<String,Integer> f2 = new BSTMap<>();
        BSTMap<String,Integer> f3 = new BSTMap<>();
        BSTMap<String,BSTree<String>> f4 = new BSTMap<>();
        for(int i=0;i<N;i++){
            String name = in.next();
            String ex = in.next();
            String estado = in.next();
            in.nextLine();
            f1.insert(name);
            if(f2.get(ex)==null)
                f2.put(ex,1);
            else
                f2.put(ex,f2.get(ex)+1);
            if(f2.get(ex)>max){
                max = f2.get(ex);
                exercicio = ex;
            }
            if(f3.get(ex)==null){
                if(estado.equals("Accepted"))
                    f3.put(ex,1);
                else{
                    f3.put(ex,0); 
                }
            }
            else {
                if(estado.equals("Accepted"))
                    f3.put(ex,f3.get(ex)+1);
            }
            if(f4.get(name)==null){
                if(estado.equals("Accepted")){
                BSTree<String> t = new BSTree<>();
                t.insert(ex);
                f4.put(name,t);
                }
            }
            else{
                if(estado.equals("Accepted")){
                f4.get(name).insert(ex);
                f4.put(name,f4.get(name));
                }
            }
        }
        if(F==1){
            System.out.println(f1.numberNodes());
        }
        if(F==2){
            System.out.println(exercicio+" "+max);
        }
        if(F==3){
        for(String key : f3.keys()){
            if(((float)f3.get(key)/(float)f2.get(key))>=0.5)
                System.out.println(key);
        }     
        }
        if(F==4){
            for(String name :f4.keys()){
                if(f4.get(name).numberNodes()==f3.size()){
                    System.out.println(name);
                }
            }
        }

    }
}*/