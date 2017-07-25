import java.util.Scanner;

class Test{

  static Node reverse(Node node){
    Node prev = null;
    Node current = node;
    Node next = null;
    while(current != null){
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
  static Node reversedSecondHalf(LinkedList ll){
    Node first = ll.head;
    Node second = ll.head.next;
    while(second != null && second.next != null ){
      first = first.next;
      second = second.next.next;
    }
    Node lastOfFirstHalf = first;
    lastOfFirstHalf.next = reverse(lastOfFirstHalf.next);
    return ll.head;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    LinkedList ll = new LinkedList();
    int size = scan.nextInt();
    for(int i = 1; i <= size; i++) ll.add(i);
    ll.print();
    ll.print(reversedSecondHalf(ll));
  }
}
