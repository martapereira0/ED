class ED196{
  public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b){
    while(!q.isEmpty()){
      String name = q.dequeue();
      String fila = q.dequeue();
      if(fila.equals("X") && a.size()<b.size()){ a.enqueue(name);}
      else if(fila.equals("X") && a.size()>b.size()){ b.enqueue(name);}
      else if(fila.equals("B")) { b.enqueue(name);}
      else if(fila.equals("A")){a.enqueue(name);}
      else continue;
    }
  }
}
