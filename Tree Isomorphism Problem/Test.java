class Test{

  static boolean isIsomorphic(Node one, Node two){
    if(one == null && two == null ) return true;
    if(one == null || two == null ) return false;
    if(one.data != two.data) return false;
    return ( isIsomorphic(one.left, two.left) && isIsomorphic(one.right, two.right) )
    || ( isIsomorphic(one.left, two.right) && isIsomorphic(one.right, two.left) );
  }

  public static void main(String[] args) {

    //Tree1 construction
    BinaryTree bt1 = new BinaryTree();
    bt1.root = new Node(1);
    bt1.root.left = new Node(2);
    bt1.root.right = new Node(3);
    bt1.root.left.left = new Node(4);
    bt1.root.left.right = new Node(5);
    bt1.root.right.left = new Node(6);
    bt1.root.left.right.left = new Node(7);
    bt1.root.left.right.right = new Node(8);

    //Tree2 construction
    BinaryTree bt2 = new BinaryTree();
    bt2.root = new Node(1);
    bt2.root.right = new Node(2);
    bt2.root.left  = new Node(3);
    bt2.root.right.left = new Node(4);
    bt2.root.right.right = new Node(5);
    bt2.root.left.right = new Node(6);
    bt2.root.right.right.right = new Node(7);
    bt2.root.right.right.left = new Node(8);

    //isIsomorphic checking
    System.out.println(isIsomorphic(bt1.root, bt2.root));
  }
}
