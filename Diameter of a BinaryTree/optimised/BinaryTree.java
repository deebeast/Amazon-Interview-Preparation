class Node{
  int data;
  Node left, right;
  public Node(int item){
    data = item;
    left = right = null;
  }
}
class Height{
  int h;
}
class BinaryTree{

  Node root;

  int diameterOpt(Node root,Height height){

    Height leftHeight = new Height();
    Height rightHeight = new Height();

    if(root == null){
        height.h = 0;
        return 0;
    }

    leftHeight.h++;
    rightHeight.h++;

    int leftDiameter = diameterOpt(root.left, leftHeight);
    int rightDiameter = diameterOpt(root.right, rightHeight);
    height.h = Math.max(leftHeight.h, rightHeight.h) + 1;

    return Math.max(leftHeight.h + rightHeight.h + 1, Math.max(leftDiameter, rightDiameter));
  }
  int diameter(){
    Height height = new Height();
    return diameterOpt(root, height);
  }
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    System.out.println("The diameter of given binary tree is : " + tree.diameter());
  }
}
