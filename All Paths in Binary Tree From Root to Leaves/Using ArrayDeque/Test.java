import java.util.ArrayDeque;

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

  ArrayDeque<Integer> path = new ArrayDeque<>();

  void printAllPaths(){
    if(this.root != null) printAllPaths(this.root);
  }

  void printAllPaths(Node root){
    path.add(root.data);
    if(root.left == null & root.right == null) print(path);
    if(root.left != null) printAllPaths(root.left );
    if(root.right != null) printAllPaths(root.right);
    path.removeLast();
  }

  void print(ArrayDeque<Integer> path){
    for(Integer data : path) System.out.print(data + " ");
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
