import java.util.Stack;
class Queue{
  Stack<Integer> s1;
  Stack<Integer> s2;
  public Queue(){
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  void insert(int data){
    s1.push(data);
  }

  void transfer(){
    while(!s1.isEmpty()) s2.push(s1.pop());
  }

  boolean remove(){
      if(print()){
        s2.pop();
        return true;
      }
      return false;
  }
  boolean print(){
    if(s2.isEmpty()) transfer();
    if(s2.isEmpty()){
      System.out.println("Queue is Empty");
      return false;
    }
    System.out.println(s2.peek());
    return true;
  }
}
