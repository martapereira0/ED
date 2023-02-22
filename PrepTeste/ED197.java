class ED197{
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
      MyQueue<Integer> newlist = new LinkedListQueue<>();
      while(!a.isEmpty() && !b.isEmpty()){
        if(a.first()<b.first()){
          newlist.enqueue(a.dequeue());
        }
        else{
          newlist.enqueue(b.dequeue());
        }
      }
      while(!a.isEmpty()){
        newlist.enqueue(a.dequeue());
      }
      while(!b.isEmpty()){
        newlist.enqueue(b.dequeue());
      }
    return newlist;
  }
}
