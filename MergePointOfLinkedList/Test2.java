/*
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int FindMergeNode(Node headA, Node headB) {
    int lenofA = 0, lenofB = 0;
    Node curr = headA;
    while (curr != null){
        lenofA++;
        curr = curr.next;
    }
    curr = headB;
    while (curr != null){
        lenofB++;
        curr = curr.next;
    }
    int diff = Math.abs(lenofA - lenofB);
    if (lenofA > lenofB) return func(headA, headB, diff);
    else return func(headB, headA, diff);
}
int func(Node greater, Node smaller, int diff) {
    Node curr1 = greater;
    Node curr2 = smaller;
    while (diff-- > 0) curr1 = curr1.next;
    while(curr1.next != null) {
        if(curr1 == curr2) return curr1.data;
        curr1 = curr1.next;
        curr2 = curr2.next;
    }
    return curr1.data;
}
