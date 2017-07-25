class LinkedList{
  Node head;
  Node current;
  public LinkedList(){
    head = null;
  }
  void add(int data){
    if(head == null){
      head = new Node(data);
      current = head;
    } else{
      Node temp = new Node(data);
      current.next = temp;
      current = current.next;
    }
  }
  void print(){
    print(this.head);
  }
  void print(Node node){
    Node n = node;
    while (n != null){
            System.out.print(n.data + "->");
            n = n.next;
    }
    System.out.println("null");
  }

}
