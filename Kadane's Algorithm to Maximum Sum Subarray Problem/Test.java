import java.util.Scanner;

class Test{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int size = scan.nextInt();
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = scan.nextInt();
    }
    System.out.println(kadane(array, size));
  }
  static int kadane(int[] array, int size){
    int maxCurrent = array[0];
    int maxGlobal = array[0];
    for(int i = 1; i < size; i++){
      maxCurrent = Math.max( (maxCurrent + array[i]), array[i]);
      if(maxCurrent > maxGlobal) maxGlobal = maxCurrent;
    }
    return maxGlobal;
  }
}
