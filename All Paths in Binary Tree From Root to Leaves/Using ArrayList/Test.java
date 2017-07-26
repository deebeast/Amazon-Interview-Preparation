import java.util.ArrayList;

class Node{
  int data;
  Node left, right;
  public Node(int d){
    data = d;
    left = right = null;
  }
}

class BinaryTree{
  Node root;
  public BinaryTree(){
    root = null;
  }

  ArrayList<Integer> al = new ArrayList<>();

  void printAllPaths(){
    if(this.root != null) printAllPaths(this.root);
  }

  void printAllPaths(Node root){
    al.add(root.data);
    if(root.left == null & root.right == null) print(al);
    if(root.left != null) printAllPaths(root.left );
    if(root.right != null) printAllPaths(root.right);
    al.remove(al.size() - 1);
  }

  void print(ArrayList<Integer> al){
    for(Integer data : al) System.out.print(data + " ");
    System.out.println();
  }
}

class Test{
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(7);
    tree.printAllPaths();
  }
}
