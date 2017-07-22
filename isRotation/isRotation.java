import java.util.Scanner;

class isRotation {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("String s1 : ");
    String s1 = scan.next();
    System.out.print("String s2 : ");
    String s2 = scan.next();
    boolean isRotation = isRotation(s1,s2);
    System.out.println("The String " + s2 + " is " + ((isRotation)?"":"not ") + "a rotation of " + s1);

  }
  static boolean isRotation (String s1, String s2) {
    int len = s1.length();
    if(len == s2.length() && len > 0){
        return (s1 + s1).contains(s2);
    }
    return false;

  }

}
