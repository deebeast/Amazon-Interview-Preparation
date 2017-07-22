import java.util.Scanner;

class Test{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String a = scan.next();
    String b = scan.next();
    System.out.println("The Strings " + a + " and " + b + " are " + (anagrams(a, b)?"":"not ") + "anagrams.");
  }

  static boolean anagrams(String a, String b){
    if(a.length() == b.length()){
      //assumption that input contains only small alphabets
      int[] countArray = new int[26];
      for(int i = 0; i < a.length(); i++){
        countArray[a.charAt(i) - 'a']++;
      }
      for(int i = 0; i < b.length(); i++){
        countArray[b.charAt(i) - 'a']--;
        if(countArray[b.charAt(i) - 'a'] < 0) return false;
      }
      return true;
    }
    else return false;
  }
}
